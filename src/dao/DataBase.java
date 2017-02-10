package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dom4j.Element;

import Control.Player;

public class DataBase implements Data {
	
	private String url;
	
	private String user;
	
	private String password;

	public DataBase(Element database) {
		url = database.attributeValue("url");
		user = database.attributeValue("user");
		password = database.attributeValue("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setData(Player player) {
		List<Player> players = this.loadData();
		players.add(player);
		Collections.sort(players);

	}

	@Override
	public List<Player> loadData() {
		String statement = "select * from user_score order by score desc limit 5";
		ArrayList<Player> players = new ArrayList<Player>();
		try {
			java.sql.Connection conn = DriverManager.getConnection(url, user, password);
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(statement);
			while(rs.next()){						
				players.add(new Player(rs.getString("user_name"), rs.getInt("score")));
			}
			while(players.size()<5){
				players.add(null);
				System.out.println("fjksadhkjsafhkjsf");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort(players);
		return players;
	}

}
