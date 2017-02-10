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
	 * ���ڱ߿���
	 */
	protected static int BORDER;

	/**
	 * �����ڱ߾�
	 */
	private static int PADDING;

	/**
	 * ����������
	 */
	protected static int ACT_W;

	/**
	 * ֵ�ۿ��
	 */
	protected static int RECT_W;

	/**
	 * ֵ�۸߶�
	 */
	protected static int RECT_H;

	/**
	 * �����ʽ
	 */
	private static Font FONT;

	/**
	 * ֵ�ۿ��
	 */
	protected int rectW;

	static {
		FrameConfig fcfg = GameConfig.getFrameConfig();
		BORDER = fcfg.getBorder();
		PADDING = fcfg.getPadding();
		ACT_W = Img.ACT.getWidth(null) / 9;
		RECT_W = Img.RECT.getWidth(null);
		RECT_H = Img.RECT.getHeight(null);
		FONT = new Font("����", Font.BOLD, 20);
	}

	/**
	 * ������ʼx����
	 */
	protected int x;

	/**
	 * ������ʼy����
	 */
	protected int y;

	/**
	 * ���ڿ��
	 */
	protected int w;

	/**
	 * ���ڸ߶�
	 */
	protected int h;

	/**
	 * dto����
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
	 * ����dto����
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	public abstract void paint(Graphics g);

	/**
	 * ����ֵ��
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
	 * �ڴ������Ļ���ͼƬ
	 */
	protected void drawImageAtCenter(Graphics g, Image img) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}

}
