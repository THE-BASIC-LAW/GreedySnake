package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Control.Player;
import dao.Data;
import dto.GameDto;
import util.FrameUtil;

public class JFrameSavaScore extends JFrame {
	
	private JLabel jl;
	
	private JTextField jtf;
	
	private JButton btn;
	
	public JFrameSavaScore(Data data,GameDto dto) {
		this.setSize(400,200);
		FrameUtil.setFrameCenter(this);
		this.setLayout(new BorderLayout());
		JPanel jp = new JPanel(new FlowLayout());
		this.jl = new JLabel("请输入您的昵称");
		jp.add(jl);
		this.jtf = new JTextField(16);
		jp.add(jtf);
		this.add(jp,BorderLayout.NORTH);
		this.btn = new JButton("确定");
		this.btn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
					data.setData(new Player(jtf.getText(),dto.getScore()));	
					setVisible(false);
			}
		});
		this.add(btn,BorderLayout.SOUTH);
	}
}
