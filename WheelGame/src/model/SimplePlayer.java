//Further Programming Assignment 1 by Alex Huang s3628653
package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerID;
	private String playerName;
	private int playerPoints;
	private int playerBet;
	private BetType betType;

	public SimplePlayer(String playerID, String playerName, int intPoints) {
		// TODO Auto-generated constructor stub
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerPoints = intPoints;
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return this.playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return this.playerPoints;
	}

	@Override
	public void setPoints(int points) {
		this.playerPoints = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerID;
	}

	@Override
	public boolean setBet(int bet) {
		if (bet > 0 && bet <= this.playerPoints) {
			this.playerBet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return this.playerBet;
	}

	@Override
	public void setBetType(BetType betType) {
		// TODO Auto-generated method stub
		this.betType = betType;
	}

	@Override
	public BetType getBetType() {
		return this.betType;
	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub
		this.playerBet = 0;
	}
	
	@Override
	   public String toString() {
		return String.format("Player: id=%s, name=%s, bet=%d, betType=%s, points=%d", 
				this.playerID,this.playerName,this.playerBet,this.betType,this.playerPoints);
	}
	

}
