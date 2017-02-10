package ui;

import java.awt.Graphics;

public class LayerScore extends Layer {

	private int numberW = Img.NUMBER.getWidth(null) / 10;

	private int numberH = Img.NUMBER.getHeight(null);

	private int scoreH = Img.SCORE.getHeight(null);

	public LayerScore(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(Img.SCORE, x + (BORDER << 1), y + (BORDER << 1), null);
		g.drawImage(Img.LV, x + (BORDER << 1), y + scoreH + (BORDER << 2), null);
		this.drawNumber(g, dto.getScore(), y + (BORDER << 1));
		this.drawNumber(g, dto.getLevel(), y + scoreH + (BORDER << 2));
		// 获取分数信息
		int score = dto.getScore();
		// 获取值槽百分比
		double percent = (double)(score % 10) / 10;
		// 绘制值槽
		this.drawRect(g, x + (BORDER << 1), y + (scoreH << 1) + (BORDER * 6), "下一级",percent);
	}

	/**
	 * 右对齐显示数字
	 */
	private void drawNumber(Graphics g, int number, int y) {
		String str = String.valueOf(number);
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int j = Integer.valueOf(str.substring(i, i + 1));
			int startX = this.x + this.w - (BORDER << 2) + (i - len) * numberW;
			g.drawImage(Img.NUMBER, startX, y, startX + numberW, y + scoreH, j * numberW, 0, (j + 1) * numberW, numberH,
					null);
		}

	}

}
