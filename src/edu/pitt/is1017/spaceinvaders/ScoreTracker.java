package edu.pitt.is1017.spaceinvaders;
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
		
		String sql = "SELECT * FROM `alieninvasion`.`finalscores` WHERE `userID` = \"" + user.getUserID() + "\"";
	}
}
