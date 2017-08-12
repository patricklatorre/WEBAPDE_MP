package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.User;
import db.DBPool;

public class UserService {
	public static void addUser(User user) {
		String sql = "INSERT INTO " + User.TABLE_NAME + " ("
				+ User.COLUMN_USERNAME + ", "
				+ User.COLUMN_DESCRIPTION
				+ ") VALUES(?, ?)";
	
	
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("connection closed");
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean userExists(String username) {
		boolean userExists = true;
		
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE username = \'" + username + "\'";
		
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()) {
				userExists = false;
			} 
		} catch (SQLException e) {
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
		
		return userExists;
	}
	
	public static int getUserIdByUsername(String username) {
		int userId = 0;
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE username = \'" + username + "\'";
		
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userId = resultSet.getInt(User.COLUMN_IDUSER);
			}
		} catch (SQLException e) {
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
		return userId;
	}
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		String sql = "SELECT * FROM " + User.TABLE_NAME;
		
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet  = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setIduser(resultSet.getInt(User.COLUMN_IDUSER));
				user.setUsername(resultSet.getString(User.COLUMN_USERNAME));
				user.setDescription(resultSet.getString(User.COLUMN_DESCRIPTION));
				users.add(user);
			}
		} catch (SQLException e) {
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
		return users;
	}
	
	public static User getUserByUsername(String username) {
		User user = new User();
		String sql = "SELECT * FROM " + User.TABLE_NAME + " WHERE username = " + "\'" + username + "\'";
		
		Connection connection = DBPool.getInstance().getConnection();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user.setIduser(resultSet.getInt(User.COLUMN_IDUSER));
				user.setUsername(resultSet.getString(User.COLUMN_USERNAME));
				user.setDescription(resultSet.getString(User.COLUMN_DESCRIPTION));
			}
		} catch (SQLException e) {
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
		return user;
	}
}
