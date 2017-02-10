package configure;

import org.dom4j.Element;

public class SystemConfig {

	private final int minX;
	
	private final int maxX;
	
	private final int minY;
	
	private final int maxY;
	
	public SystemConfig(Element element){
		//游戏主体窗口最小横轴坐标
		minX = Integer.parseInt(element.attributeValue("minX"));
		//游戏主体窗口最大横轴坐标
		maxX = Integer.parseInt(element.attributeValue("maxX"));
		//游戏主体窗口最小纵轴坐标
		minY = Integer.parseInt(element.attributeValue("minY"));
		//游戏主体窗口最大纵轴坐标
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
