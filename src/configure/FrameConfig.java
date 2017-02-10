package configure;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {

	/**
	 * 窗口配置数组
	 */
	private final List<Element> layerElements;

	/**
	 * 主窗体标题
	 */
	private final String title;

	/**
	 * 主窗体宽度
	 */
	private final int width;

	/**
	 * 主窗体高度
	 */
	private final int height;

	/**
	 * 边框宽度
	 */
	private final int border;

	/**
	 * 内边距大小
	 */
	private final int padding;
	
	/**
	 * 按钮配置
	 */
	private ButtonConfig btnConfig;

	@SuppressWarnings("unchecked")
	public FrameConfig(Element frame) {
		// 获取层配置列表
		layerElements = (ArrayList<Element>) frame.elements("layer");
		// 获取窗口标题
		title = frame.attributeValue("title");
		// 获取主窗体宽度
		width = Integer.parseInt(frame.attributeValue("width"));
		// 获取主窗体高度
		height = Integer.parseInt(frame.attributeValue("height"));
		// 获取边框宽度
		border = Integer.parseInt(frame.attributeValue("border"));
		// 获取内边距大小
		padding = Integer.parseInt(frame.attributeValue("padding"));
		// 获取按钮设置配置
		btnConfig = new ButtonConfig(frame.element("button"));
	}

	public List<Element> getLayerElements() {
		return layerElements;
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getBorder() {
		return border;
	}

	public int getPadding() {
		return padding;
	}

	public ButtonConfig getBtnConfig() {
		return btnConfig;
	}

}
