package windows;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import configure.GameConfig;
import dto.GameDto;
import util.FrameUtil;

public class JFrameGame extends JFrame {

	/**
	 * 获取主窗口宽度
	 */
	private static int width = GameConfig.getFrameConfig().getWidth();

	/**
	 * 获取主窗口高度
	 */
	private static int height = GameConfig.getFrameConfig().getHeight();

	public JFrameGame(JPanelGame panelGame) {
		// 设置窗口大小
		this.setSize(width, height);
		// 设置窗口不可拉伸
		this.setResizable(false);
		// 设置关闭退出
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置窗口画面
		this.setContentPane(panelGame);
		// 设置窗口居中
		FrameUtil.setFrameCenter(this);
		// 设置窗口可见
		this.setVisible(true);
	}
}
