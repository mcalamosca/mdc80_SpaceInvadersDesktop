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
		
		String initScore = "INSERT INTO `alieninvasion`.runningscores`(`gameID`,`scoreValue`,`fk_userID`) ";
		initScore += "VALUES (\""+this.gameID+"\",\"" +this.currentScore+"\",\""+this.user.getUserID()+"\");";
		
		db.executeQuery(initScore);
		
		String highScore = "SELECT MAX(scoreValue) FROM `alieninvasion`.`finalscores` ";
		highScore	+= "WHERE `fk_userID` = \"" + user.getUserID() + "\"";
			
		ResultSet rs = db.getResultSet(highScore);
		
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
		
		String updateScore = "UPDATE `alieninvasion`.`runningscores` SET `scoreValue`=`"+ getCurrentScore() +"` ";
		updateScore += "WHERE `gameID`=`"+this.gameID+"` AND `userID`=`"+this.user.getUserID()+"`;";
	}
	
	public void recordFinalScore(){
		DbUtilities db = new DbUtilities();		

	}

	public int getCurrentScore() {
		return currentScore;
	}

	public int getHighestScore() {
		return highestScore;
	}
	
	
}
