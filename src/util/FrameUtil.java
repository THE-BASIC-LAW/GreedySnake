package util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameUtil {

	public static void setFrameCenter(JFrame jf){
		//获得本机本地硬件配置信息
		Toolkit tk = Toolkit.getDefaultToolkit();
		//获得屏幕尺寸
		Dimension dm = tk.getScreenSize();
		//获取起始X坐标
		int startX = dm.width-jf.getWidth()>>1;
		//获取其实Y坐标
		int startY = dm.height-jf.getHeight()>>1;
		//设置jf窗体位置
		jf.setLocation(startX, startY);
	}
	
}
