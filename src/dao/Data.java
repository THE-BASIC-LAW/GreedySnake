package dao;

import java.util.List;

import Control.Player;

public interface Data {

	public void setData(Player player);
	
	public List<Player> loadData();
	
}
