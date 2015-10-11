package com.hack4b;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 该类提供配置文件参数的读取操作
 * @author on ice
 *
 */
public class ConfReader {
	
	/**
	 * 端口号
	 */
	private String[] port = null;
	
	/**
	 * 日志文件配置信息
	 */
	private String logFile;
	
	public ConfReader() throws DocumentException {
		//创建xml阅读器
		SAXReader reader = new SAXReader();
		//读取配置文件
		Document conf = reader.read("conf.xml");
		//获取配置文件的根节点
		Element rootElement = conf.getRootElement();
		//设置端口
		this.port = rootElement.elementText("Honeypot-port").split(",");
		//设置日志文件
		this.logFile = rootElement.elementText("Honeypot-log");
	}

	public String[] getPort() {
		return port;
	}

	public String getLog() {
		return logFile;
	}
}
