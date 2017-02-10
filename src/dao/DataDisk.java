package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dom4j.Element;

import Control.Player;

public class DataDisk implements Data {
	
	private List<Player> players;
	
	private String path;

	public DataDisk(Element datadisk) {
		this.path = datadisk.attributeValue("path");
	}

	@Override
	public void setData(Player player) {
		players = this.loadData();
		players.add(player);
		Collections.sort(players);
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(players);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> loadData() {
		ObjectInputStream ois = null;
		try{
		ois = new ObjectInputStream(new FileInputStream(path));
		players = (ArrayList<Player>) ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		while(players.size()<5){
			players.add(new Player("", 0));
		}
		Collections.sort(players);
		return players;
	}

}
