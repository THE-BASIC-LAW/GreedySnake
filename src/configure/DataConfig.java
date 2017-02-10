package configure;

import org.dom4j.Element;

import dao.DataBase;
import dao.DataDisk;

public class DataConfig {
	
	private DataBase dataBase;
	
	private DataDisk dataDisk;

	public DataConfig(Element data) {
		//创建数据库对象
		this.dataBase = new DataBase(data.element("database"));
		//创建本地数据元素
		this.dataDisk = new DataDisk(data.element("datadisk"));
	}

	public DataBase getDatabase() {
		return dataBase;
	}

	public DataDisk getDatadisk() {
		return dataDisk;
	}

}
