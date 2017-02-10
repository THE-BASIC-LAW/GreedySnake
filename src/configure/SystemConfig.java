package configure;

import org.dom4j.Element;

public class SystemConfig {

	private final int minX;
	
	private final int maxX;
	
	private final int minY;
	
	private final int maxY;
	
	public SystemConfig(Element element){
		//��Ϸ���崰����С��������
		minX = Integer.parseInt(element.attributeValue("minX"));
		//��Ϸ���崰������������
		maxX = Integer.parseInt(element.attributeValue("maxX"));
		//��Ϸ���崰����С��������
		minY = Integer.parseInt(element.attributeValue("minY"));
		//��Ϸ���崰�������������
		maxY = Integer.parseInt(element.attributeValue("maxY"));
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}
	
}
