package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import configure.FrameConfig;
import configure.GameConfig;
import dto.GameDto;

public abstract class Layer {

	/**
	 * 窗口边框宽度
	 */
	protected static int BORDER;

	/**
	 * 窗口内边距
	 */
	private static int PADDING;

	/**
	 * 单个方块宽度
	 */
	protected static int ACT_W;

	/**
	 * 值槽宽度
	 */
	protected static int RECT_W;

	/**
	 * 值槽高度
	 */
	protected static int RECT_H;

	/**
	 * 字体格式
	 */
	private static Font FONT;

	/**
	 * 值槽宽度
	 */
	protected int rectW;

	static {
		FrameConfig fcfg = GameConfig.getFrameConfig();
		BORDER = fcfg.getBorder();
		PADDING = fcfg.getPadding();
		ACT_W = Img.ACT.getWidth(null) / 9;
		RECT_W = Img.RECT.getWidth(null);
		RECT_H = Img.RECT.getHeight(null);
		FONT = new Font("黑体", Font.BOLD, 20);
	}

	/**
	 * 窗口起始x坐标
	 */
	protected int x;

	/**
	 * 窗口起始y坐标
	 */
	protected int y;

	/**
	 * 窗口宽度
	 */
	protected int w;

	/**
	 * 窗口高度
	 */
	protected int h;

	/**
	 * dto对象
	 */
	protected GameDto dto;

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w - (BORDER << 2);
	}

	protected void createWindow(Graphics g) {
		Image img = Img.WINDOW;
		int WINDOW_W = img.getWidth(null);
		int WINDOW_H = img.getHeight(null);
		g.drawImage(img, x, y, x + BORDER, y + BORDER, 0, 0, BORDER, BORDER, null);
		g.drawImage(img, x + BORDER, y, x + w - BORDER, y + BORDER, BORDER, 0, WINDOW_W - BORDER, BORDER, null);
		g.drawImage(img, x + w - BORDER, y, x + w, y + BORDER, WINDOW_W - BORDER, 0, WINDOW_W, BORDER, null);
		g.drawImage(img, x, y + BORDER, x + BORDER, y + h - BORDER, 0, BORDER, BORDER, WINDOW_H - BORDER, null);
		g.drawImage(img, x + w - BORDER, y + BORDER, x + w, y + h - BORDER, WINDOW_W - BORDER, BORDER, WINDOW_W,
				WINDOW_H - BORDER, null);
		g.drawImage(img, x, y + h - BORDER, x + BORDER, y + h, 0, WINDOW_H - BORDER, BORDER, WINDOW_H, null);
		g.drawImage(img, x + BORDER, y + h - BORDER, x + w - BORDER, y + h, BORDER, WINDOW_H - BORDER,
				WINDOW_W - BORDER, WINDOW_H, null);
		g.drawImage(img, x + w - BORDER, y + h - BORDER, x + w, y + h, WINDOW_W - BORDER, WINDOW_H - BORDER, WINDOW_W,
				WINDOW_H, null);
	}

	/**
	 * 设置dto对象
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	public abstract void paint(Graphics g);

	/**
	 * 绘制值槽
	 */
	protected void drawRect(Graphics g, int x, int y, String title, double percent) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, rectW, RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(x + 1, y + 1, rectW - 2, RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(x + 2, y + 2, rectW - 4, RECT_H);
		g.setColor(Color.WHITE);
		g.setFont(FONT);
		g.drawImage(Img.RECT, x + 2, y + 2, (int) (x - 2 + percent * rectW), y + 2 + RECT_H, (int) (percent * RECT_W-1),
				0, (int) (percent * RECT_W), RECT_H, null);
		g.drawString(title, x + 3, y + 23);
	}

	protected void drawRect(Graphics g, int x, int y, String title, double percent, int number) {
		drawRect(g, x, y, title, percent);
		String str = String.valueOf(number);
		int len = str.length();
		for (int i = 0; i < len; i++) {
			g.drawString(str.charAt(i) + "", x + rectW + (i - len - 1) * 10, y + 23);
		}
	}

	/**
	 * 在窗口中心绘制图片
	 */
	protected void drawImageAtCenter(Graphics g, Image img) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}

}
