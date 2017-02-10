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
		// ����dto����
		this.dto = dto;
		//���ô����С
		this.setSize(400, 200);
		//���ô������
		FrameUtil.setFrameCenter(this);
		//����Ϊ�߽粼��
		this.setLayout(new BorderLayout());
		//��ʼ�������������
		this.initComponents();
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponents() {
		//�����Ѷ������б��
		JComboBox<Integer> jcb = new JComboBox<Integer>();
		//ѭ������Ѷȵȼ�
		for (int i = 1; i < 11; i++) {
			jcb.addItem(i);
		}
		//����б�򵽴���
		this.add(jcb, BorderLayout.NORTH);
		//����ȷ����ť
		JButton btn_ok = new JButton("ȷ��");
		//����ȡ����ť
		JButton btn_cancel = new JButton("ȡ��");
		//���ɷ��ð�ť�����
		JPanel jbp = new JPanel();
		jbp.setLayout(new FlowLayout());
		//��Ӱ�ť�������
		jbp.add(btn_ok);
		jbp.add(btn_cancel);
		//�����嵽����
		this.add(jbp,BorderLayout.SOUTH);
		//����ť��ӹ���
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
