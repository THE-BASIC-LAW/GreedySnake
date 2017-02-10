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
	 * 获取层配置数组
	 */
	private static ArrayList<Element> layers = (ArrayList<Element>) GameConfig.getFrameConfig().getLayerElements();
	
	/**
	 * 开始按钮
	 */
	public JButton btn_Start = null;
	
	/**
	 * 设置按钮
	 */
	public JButton btn_Setting = null;
	
	/**
	 * 设置对话框
	 */
	private JDialog jd;

	/**
	 * dto对象
	 */
	private GameDto dto;

	public JPanelGame(GameDto dto,GameControl gameControl) {
		// 设置布局为自由布局
		this.setLayout(null);
		// 获取dto对象
		this.dto = dto;
		// 初始化按钮配置
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

	// 初始化难度设置对话框
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
	// 循环绘制子窗口
	public void paintComponent(Graphics g) {
		// 调用基类方法
		super.paintComponent(g);
		g.drawImage(Img.BG, 0, 0, this.getWidth(), this.getHeight(), null);
		try {
			for (int i = 0; i < layers.size(); i++) {
				int x = Integer.parseInt(layers.get(i).attributeValue("x"));
				int y = Integer.parseInt(layers.get(i).attributeValue("y"));
				int w = Integer.parseInt(layers.get(i).attributeValue("width"));
				int h = Integer.parseInt(layers.get(i).attributeValue("height"));
				// 获得类名
				String clsName = layers.get(i).attributeValue("className");
				// 获得类对象
				Class<?> cls = Class.forName(clsName);
				// 获取构造器
				Constructor ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// 使用构造器创建新对象
				Layer ly = (Layer) ctr.newInstance(x, y, w, h);
				// 获取dto对象
				ly.setDto(dto);
				// 绘制窗口
				ly.paint(g);
			}
			// 获取焦点
			this.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}