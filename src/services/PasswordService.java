package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBPool;

public class PasswordService {
	public static final String TABLE_NAME = "passwords";
	public static final String COLUMN_PASSWORD = "password";
	
	public static boolean passwordMatches(int userId, String password) {
		String check = "";
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE iduser = " + userId;
		
		Connection connection = DBPool.getInstance().getConnection();
		ResultSet resultSet = null;
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				check = resultSet.getString(COLUMN_PASSWORD);
			}
		} catch  (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(check.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void setPassword(int userId, String password) {
		String sql = "INSERT INTO passwords" + " (iduser, password) VALUES (?, ?)";
		
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
