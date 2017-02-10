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
	 * ��ȡ�����ڿ��
	 */
	private static int width = GameConfig.getFrameConfig().getWidth();

	/**
	 * ��ȡ�����ڸ߶�
	 */
	private static int height = GameConfig.getFrameConfig().getHeight();

	public JFrameGame(JPanelGame panelGame) {
		// ���ô��ڴ�С
		this.setSize(width, height);
		// ���ô��ڲ�������
		this.setResizable(false);
		// ���ùر��˳�
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���ô��ڻ���
		this.setContentPane(panelGame);
		// ���ô��ھ���
		FrameUtil.setFrameCenter(this);
		// ���ô��ڿɼ�
		this.setVisible(true);
	}
}
