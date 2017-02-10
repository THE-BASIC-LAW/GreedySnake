package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dto.GameDto;
import util.FrameUtil;

public class JFrameConfig extends JFrame {
	
	private GameDto dto;

	public JFrameConfig(GameDto dto) {
		// 设置dto对象
		this.dto = dto;
		//设置窗体大小
		this.setSize(400, 200);
		//设置窗体居中
		FrameUtil.setFrameCenter(this);
		//设置为边界布局
		this.setLayout(new BorderLayout());
		//初始化组件方法调用
		this.initComponents();
	}

	/**
	 * 初始化组件
	 */
	private void initComponents() {
		//创建难度下拉列表框
		JComboBox<Integer> jcb = new JComboBox<Integer>();
		//循环添加难度等级
		for (int i = 1; i < 11; i++) {
			jcb.addItem(i);
		}
		//添加列表框到窗体
		this.add(jcb, BorderLayout.NORTH);
		//生成确定按钮
		JButton btn_ok = new JButton("确定");
		//生成取消按钮
		JButton btn_cancel = new JButton("取消");
		//生成放置按钮的面板
		JPanel jbp = new JPanel();
		jbp.setLayout(new FlowLayout());
		//添加按钮到面板上
		jbp.add(btn_ok);
		jbp.add(btn_cancel);
		//添加面板到窗体
		this.add(jbp,BorderLayout.SOUTH);
		//给按钮添加功能
		btn_ok.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dto.setSleepTime(550-(int)jcb.getSelectedItem()*50);
				System.out.println(dto.getSleepTime());
				setVisible(false);
			}
		});
		btn_cancel.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
