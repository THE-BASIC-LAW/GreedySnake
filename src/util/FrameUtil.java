package util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameUtil {

	public static void setFrameCenter(JFrame jf){
		//��ñ�������Ӳ��������Ϣ
		Toolkit tk = Toolkit.getDefaultToolkit();
		//�����Ļ�ߴ�
		Dimension dm = tk.getScreenSize();
		//��ȡ��ʼX����
		int startX = dm.width-jf.getWidth()>>1;
		//��ȡ��ʵY����
		int startY = dm.height-jf.getHeight()>>1;
		//����jf����λ��
		jf.setLocation(startX, startY);
	}
	
}
