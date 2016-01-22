package edu.pitt.is1017.spaceinvaders;

public class Tester {

	public static void main(String[] args) {
		DbUtilities db = new DbUtilities();
		
		String firstname = "Micah", lastname = "Calamosca", email = "mdc80@pitt.edu", password = "password";
		
		String sql = "INSERT INTO `alieninvasion`.`users` ";
		sql = sql + "(`lastName`,`firstName`,`email`,`password`) ";
		sql = sql + "VALUES	(`"+ lastname +"`,`" + firstname + "`,`" + email + "`,`md5(" + password + "`)";

		
		
	}

}
