package com.hack4b;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 配置文件读取器
 * @author on ice
 *
 */
public class ConfReader {
	
	/**
	 * 端口
	 */
	private String[] port = null;
	
	/**
	 * 日志文件
	 */
	private String logFile;
	
	/**
	 * 消息
	 */
	private String message;
	
	public ConfReader() throws DocumentException {
		//创建xml阅读器
		SAXReader reader = new SAXReader();
		//读取配置文件
		Document conf = reader.read("conf.xml");
		//获取配置文件的根节点
		Element rootElement = conf.getRootElement();
		//获取配置文件端口
		this.port = rootElement.elementText("Honeypot-port").split(",");
		//获取配置文件日志
		this.logFile = rootElement.elementText("Honeypot-log");
		//获取配置文件消息
		this.message = rootElement.elementText("Honeypot-message");
	}

	public String[] getPort() {
		return port;
	}

	public String getLog() {
		return logFile;
	}
	
	public String getMessage(){
		return message;
	}
}
