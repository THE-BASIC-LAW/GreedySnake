package windows;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.dom4j.Element;

import Control.GameControl;
import configure.ButtonConfig;
import configure.GameConfig;
import dto.GameDto;
import ui.Img;
import ui.Layer;

public class JPanelGame extends JPanel {

	/**
	 * ��ȡ����������
	 */
	private static ArrayList<Element> layers = (ArrayList<Element>) GameConfig.getFrameConfig().getLayerElements();
	
	/**
	 * ��ʼ��ť
	 */
	public JButton btn_Start = null;
	
	/**
	 * ���ð�ť
	 */
	public JButton btn_Setting = null;
	
	/**
	 * ���öԻ���
	 */
	private JDialog jd;

	/**
	 * dto����
	 */
	private GameDto dto;

	public JPanelGame(GameDto dto,GameControl gameControl) {
		// ���ò���Ϊ���ɲ���
		this.setLayout(null);
		// ��ȡdto����
		this.dto = dto;
		// ��ʼ����ť����
		this.intiComponent(gameControl);
	}

	private void intiComponent(GameControl gameControl) {
		ButtonConfig bcfg = GameConfig.getFrameConfig().getBtnConfig();
		btn_Start = new JButton(Img.BTN_START);
		btn_Start.setBounds(bcfg.getStartX(), bcfg.getStartY(), bcfg.getBtnW(), bcfg.getBtnH());
		btn_Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					gameControl.start();
			}
		});
		
		btn_Setting = new JButton(Img.BTN_SETTING);
		btn_Setting.setBounds(bcfg.getSettingX(), bcfg.getSettingY(), bcfg.getBtnW(), bcfg.getBtnH());
		btn_Setting.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {			
				new JFrameConfig(dto).setVisible(true);
			}
		});
		
		this.initJd();
		
		this.add(btn_Start);
		this.add(btn_Setting);
	}

	// ��ʼ���Ѷ����öԻ���
	private void initJd() {
		jd = new JDialog();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension ds = tk.getScreenSize();
		jd.setBounds(ds.width/2-200, ds.height/2-100, 400, 200);
		jd.setLayout(new BorderLayout());
		JComboBox<Integer> jcb = new JComboBox<Integer>();
		for(int i=1;i<11;i++){
			jcb.addItem(i);
		}
		jd.add(jcb,BorderLayout.NORTH);
		jd.setTitle("Choose Initial Level");
	}

	@Override
	// ѭ�������Ӵ���
	public void paintComponent(Graphics g) {
		// ���û��෽��
		super.paintComponent(g);
		g.drawImage(Img.BG, 0, 0, this.getWidth(), this.getHeight(), null);
		try {
			for (int i = 0; i < layers.size(); i++) {
				int x = Integer.parseInt(layers.get(i).attributeValue("x"));
				int y = Integer.parseInt(layers.get(i).attributeValue("y"));
				int w = Integer.parseInt(layers.get(i).attributeValue("width"));
				int h = Integer.parseInt(layers.get(i).attributeValue("height"));
				// �������
				String clsName = layers.get(i).attributeValue("className");
				// ��������
				Class<?> cls = Class.forName(clsName);
				// ��ȡ������
				Constructor ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// ʹ�ù����������¶���
				Layer ly = (Layer) ctr.newInstance(x, y, w, h);
				// ��ȡdto����
				ly.setDto(dto);
				// ���ƴ���
				ly.paint(g);
			}
			// ��ȡ����
			this.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}