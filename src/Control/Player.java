package Control;

import java.io.Serializable;

public class Player implements Comparable<Player>,Serializable {

	private String playerName;

	private int playerScore;
	
	public Player(String name,int score){
		this.playerName = name;
		this.playerScore = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	@Override
	public int compareTo(Player player) {
		return player.playerScore - this.playerScore;
	}

}
