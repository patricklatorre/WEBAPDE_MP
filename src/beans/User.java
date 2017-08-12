package beans;

import java.io.Serializable;

public class User implements Serializable {
	public static final String TABLE_NAME = "users";
	public static final String COLUMN_IDUSER = "iduser";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_DESCRIPTION = "description";
	
	private int iduser;
	private String username;
	private String description;
	
	public User() {
		
	}
	
	public User(String username) {
		this.username = username;
	}
	
	public int getIduser() {
		return iduser;
	}
	
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
