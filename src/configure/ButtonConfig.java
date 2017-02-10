package configure;

import org.dom4j.Element;

public class ButtonConfig {

	/**
	 * ��ť���
	 */
	private int btnW;
	
	/**
	 * ��ť�߶�
	 */
	private int btnH;
	
	private int StartX;
	
	private int StartY;
	
	private int SettingX;
	
	private int SettingY;
	
	public ButtonConfig(Element button) {
		// ��ȡStartԪ��
		Element btnStart = button.element("start");
		// ��ȡSettingԪ��
		Element btnSetting = button.element("setting");
		// ��ȡ��ť���
		btnW = Integer.parseInt(button.attributeValue("w"));
		// ��ȡ��ť�߶�
		btnH = Integer.parseInt(button.attributeValue("h"));
		// ��ȡ��ʼ��ť��ʼX����
		StartX = Integer.parseInt(btnStart.attributeValue("x"));
		// ��ȡ��ʼ��ť��ʼY����
		StartY = Integer.parseInt(btnStart.attributeValue("y"));
		// ��ȡ���ð�ť��ʼX����
		SettingX = Integer.parseInt(btnSetting.attributeValue("x"));
		// ��ȡ���ð�ť��ʼY����
		SettingY = Integer.parseInt(btnSetting.attributeValue("y"));
	}

	public int getBtnW() {
		return btnW;
	}

	public int getBtnH() {
		return btnH;
	}

	public int getStartX() {
		return StartX;
	}

	public int getStartY() {
		return StartY;
	}

	public int getSettingX() {
		return SettingX;
	}

	public int getSettingY() {
		return SettingY;
	}
	
}
