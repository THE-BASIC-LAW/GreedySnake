package ui;

import java.awt.Graphics;
import java.util.List;

import Control.Player;
import dao.DataBase;

public class LayerData extends Layer {

	private DataBase dataBase;

	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		this.dataBase = dto.getDataBase();
		this.createWindow(g);
		g.drawImage(Img.DB, x + (BORDER << 1), y + (BORDER << 1), null);
		List<Player> players = dataBase.loadData();
		for (int i = 1; i < 6; i++) {
			double percent = (double)dto.getScore() / players.get(i - 1).getPlayerScore();
			percent = percent>1?1:percent;
			this.drawRect(g, x + (BORDER << 1), y + Img.DB.getHeight(null) + BORDER * (i + 1) + 32 * (i - 1),
					players.get(i - 1).getPlayerName(), percent, players.get(i - 1).getPlayerScore());
		}

	}

}
