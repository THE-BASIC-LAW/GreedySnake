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
		//����XML��ȡ��
		SAXReader reader = new SAXReader();
		//��ȡXML�ļ�
		Document doc = reader.read("data/cfg.xml");
		//��ȡ���ڵ�
		Element game = doc.getRootElement();
		//��ȡFrame����
		FRAME_CONFIG = new FrameConfig(game.element("frame"));
		//��ȡϵͳ����
		SYSTEM_CONFIG = new SystemConfig(game.element("system"));
		//��ȡ��������
		DATA_CONFIG = new DataConfig(game.element("data"));
		//��ʼ��������ֵ��
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
