package edu.pitt.is1017.spaceinvaders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JOptionPane;

public class ScoreTracker {
		
	
	private User user;
	private int currentScore,highestScore;
	private String gameID;
	
	public ScoreTracker(User user){
		this.user=user;
		this.currentScore=0;
		this.gameID = UUID.randomUUID().toString();
		
		DbUtilities db = new DbUtilities();
		
		//Initialize row in db for current game
		String initScore = "INSERT INTO alieninvasion.runningscores(`gameID`,`scoreType`,`scoreValue`,`fk_userID`,`dateTimeEntered`) ";
		initScore += "VALUES (\""+this.gameID+"\","+1+",\"" +this.currentScore+"\",\""+this.user.getUserID()+"\",NOW());";
		
		db.executeQuery(initScore);
		
		//Select highest score for user
		String highScore = "SELECT MAX(scoreValue) FROM alieninvasion.finalscores ";
		highScore	+= "WHERE `fk_userID` = \"" + user.getUserID() + "\"";
			
		ResultSet rs = db.getResultSet(highScore);
		
		try {
			highestScore = rs.getInt("scoreValue");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.closeConnection();
	}
	
	public void recordScore(int point){
		DbUtilities db = new DbUtilities();		
		
		if(point == 1){
			currentScore++;
		}
		else if(point == -1){
			currentScore--;
		}
		
		//updates the score for the current game 
		String updateScore = "UPDATE alieninvasion.runningscores SET `scoreValue`="+ getCurrentScore() +" ";
		updateScore += "WHERE `gameID`=\""+this.gameID+"\" AND `fk_userID`="+this.user.getUserID()+";";
		
		db.executeQuery(updateScore);
		db.closeConnection();
	}
	
	public void recordFinalScore(){
		DbUtilities db = new DbUtilities();		

		String sql = "INSERT INTO alieninvasion.finalscores(`gameID`,`scoreValue`,`fk_userID`,`dateTimeEntered`) ";
		sql += "VALUES (\""+this.gameID+"\",\"" +this.currentScore+"\",\""+this.user.getUserID()+"\",NOW());";
		
		db.executeQuery(sql);
		db.closeConnection();
		
		JOptionPane.showMessageDialog(null, "Congratulations! You've won. \nYour score was: " + currentScore + "\nYour Highest Score was: " + highestScore);
		
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getHighestScore() {
		return highestScore;
	}
	
	
}
