package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int userID;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private boolean loggedIn = false;
		
	public User(int userID){
		DbUtilities db = new DbUtilities();
				
		String sql = "SELECT userID FROM `alieninvasion`.`users` WHERE userID = `" + userID + "`";
		
		ResultSet rs = db.getResultSet(sql);
		
		//needs to set appropriate values from result set
		try {
			this.userID = rs.getInt("userID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	public User(String lastName, String firstName, String email, String password){
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}
}
