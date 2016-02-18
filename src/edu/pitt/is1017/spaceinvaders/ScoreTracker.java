package edu.pitt.is1017.spaceinvaders;
import java.sql.ResultSet;
import java.util.UUID;

public class ScoreTracker {
		
	
	private User user;
	private int currentScore,highestScore;
	private String gameID;
	
	public ScoreTracker(User user){
		this.user=user;
		this.currentScore=0;
		this.gameID = UUID.randomUUID().toString();
		
		DbUtilities db = new DbUtilities();
		
		String sql = "SELECT MAX(scoreValue) FROM `alieninvasion`.`finalscores` ";
		sql	+= "WHERE `fk_userID` = \"" + user.getUserID() + "\"";
		
		ResultSet rs = db.getResultSet(sql);
		
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
		
		String initScore = "INSERT INTO `alieninvasion`.runningscores`(`gameID`,`scoreValue`,`fk_userID`) ";
		initScore += "VALUES (\""+this.gameID+"\",\"" +this.currentScore+"\",\""+this.user.getUserID()+"\");";
	}
	
	public void recordFinalScore(){
		
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getHighestScore() {
		return highestScore;
	}
	
	
}
