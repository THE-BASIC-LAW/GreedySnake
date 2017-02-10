package ui;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import dto.GameDto;

public class LayerGame extends Layer {

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.dto = new GameDto();
	}

	@Override
	public void paint(Graphics g) {
		// 绘制游戏主界面
		this.createWindow(g);
		if (dto.isStart()) {
			// 获取贪吃蛇方块数组
			ArrayList<Point> list = this.dto.getSnake();
			// 获取等级
			int lv = (dto.getLevel()) % 7 + 1;
			// 循环绘制贪吃蛇身体
			for (int i = 0; i < list.size(); i++) {
				int startX = (int) (x + list.get(i).getX() * ACT_W + BORDER);
				int startY = (int) (y + list.get(i).getY() * ACT_W + BORDER);
				int endX = (int) (x + (list.get(i).getX() + 1) * ACT_W + BORDER);
				int endY = (int) (y + (list.get(i).getY() + 1) * ACT_W + BORDER);
				if (dto.isOver()) {
					g.drawImage(Img.ACT, startX, startY, endX, endY, 0, 0, ACT_W, ACT_W, null);
				} else {
					g.drawImage(Img.ACT, startX, startY, endX, endY, lv * ACT_W, 0, (lv + 1) * ACT_W, ACT_W, null);
				}
			}
			// 绘制蛇果
			Point point = this.dto.getNext();
			int startX = (int) (x + point.getX() * ACT_W + BORDER);
			int startY = (int) (y + point.getY() * ACT_W + BORDER);
			int endX = (int) (x + (point.getX() + 1) * ACT_W + BORDER);
			int endY = (int) (y + (point.getY() + 1) * ACT_W + BORDER);
			g.drawImage(Img.ACT, startX, startY, endX, endY, ACT_W << 3, 0, ACT_W * 9, ACT_W, null);

			if (dto.isPause()) {
				this.drawImageAtCenter(g, Img.PAUSE);
			}
		}
	}
}
