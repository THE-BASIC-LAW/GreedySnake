package configure;

import org.dom4j.Element;

public class ButtonConfig {

	/**
	 * 按钮宽度
	 */
	private int btnW;
	
	/**
	 * 按钮高度
	 */
	private int btnH;
	
	private int StartX;
	
	private int StartY;
	
	private int SettingX;
	
	private int SettingY;
	
	public ButtonConfig(Element button) {
		// 获取Start元素
		Element btnStart = button.element("start");
		// 获取Setting元素
		Element btnSetting = button.element("setting");
		// 获取按钮宽度
		btnW = Integer.parseInt(button.attributeValue("w"));
		// 获取按钮高度
		btnH = Integer.parseInt(button.attributeValue("h"));
		// 获取开始按钮起始X坐标
		StartX = Integer.parseInt(btnStart.attributeValue("x"));
		// 获取开始按钮起始Y坐标
		StartY = Integer.parseInt(btnStart.attributeValue("y"));
		// 获取设置按钮起始X坐标
		SettingX = Integer.parseInt(btnSetting.attributeValue("x"));
		// 获取设置按钮起始Y坐标
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
