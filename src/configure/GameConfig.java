package configure;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {

	private static SystemConfig SYSTEM_CONFIG =null;
	
	private static FrameConfig FRAME_CONFIG = null;
	
	private static DataConfig DATA_CONFIG = null;
	
	private static Map<Integer,String> KEYCODE_CONFIG = null;
	
	public GameConfig(){
		try{
		//创建XML读取器
		SAXReader reader = new SAXReader();
		//读取XML文件
		Document doc = reader.read("data/cfg.xml");
		//获取根节点
		Element game = doc.getRootElement();
		//获取Frame配置
		FRAME_CONFIG = new FrameConfig(game.element("frame"));
		//获取系统配置
		SYSTEM_CONFIG = new SystemConfig(game.element("system"));
		//获取数据配置
		DATA_CONFIG = new DataConfig(game.element("data"));
		//初始化按键键值对
		KEYCODE_CONFIG = new HashMap<Integer,String>();
	}catch(Exception e){
		e.printStackTrace();
	}
		KEYCODE_CONFIG.put(37, "KeyLeft");
		KEYCODE_CONFIG.put(38, "KeyUp");
		KEYCODE_CONFIG.put(39, "KeyRight");
		KEYCODE_CONFIG.put(40, "KeyDown");
		KEYCODE_CONFIG.put(32, "Pause");
	}

	public static SystemConfig getSystemConfig() {
		return SYSTEM_CONFIG;
	}

	public static FrameConfig getFrameConfig() {
		return FRAME_CONFIG;
	}

	public static DataConfig getDataConfig() {
		return DATA_CONFIG;
	}

	public static Map<Integer, String> getKEYCODE_CONFIG() {
		return KEYCODE_CONFIG;
	}
	
}
