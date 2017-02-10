package configure;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {

	/**
	 * ������������
	 */
	private final List<Element> layerElements;

	/**
	 * ���������
	 */
	private final String title;

	/**
	 * ��������
	 */
	private final int width;

	/**
	 * ������߶�
	 */
	private final int height;

	/**
	 * �߿���
	 */
	private final int border;

	/**
	 * �ڱ߾��С
	 */
	private final int padding;
	
	/**
	 * ��ť����
	 */
	private ButtonConfig btnConfig;

	@SuppressWarnings("unchecked")
	public FrameConfig(Element frame) {
		// ��ȡ�������б�
		layerElements = (ArrayList<Element>) frame.elements("layer");
		// ��ȡ���ڱ���
		title = frame.attributeValue("title");
		// ��ȡ��������
		width = Integer.parseInt(frame.attributeValue("width"));
		// ��ȡ������߶�
		height = Integer.parseInt(frame.attributeValue("height"));
		// ��ȡ�߿���
		border = Integer.parseInt(frame.attributeValue("border"));
		// ��ȡ�ڱ߾��С
		padding = Integer.parseInt(frame.attributeValue("padding"));
		// ��ȡ��ť��������
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
