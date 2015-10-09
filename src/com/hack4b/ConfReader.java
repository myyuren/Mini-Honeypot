package com.hack4b;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 该类提供配置文件的读取操作
 * @author on ice
 *
 */
public class ConfReader {
	
	/**
	 * 端口配置信息
	 */
	String port;
	
	/**
	 * 日志文件配置信息
	 */
	String log;
	
	/**
	 * 获得配置文件结果
	 * @return	List[0]:端口信息 List[1]:日志文件信息
	 * @throws DocumentException
	 */
	public List<String> getConf() throws DocumentException{
		//配置文件结果集
		List<String> result = new ArrayList<>(2);
		//创建xml阅读器
		SAXReader reader = new SAXReader();
		//读取配置文件
		Document conf = reader.read("src/conf.xml");
		//获取配置文件的根节点
		Element rootElement = conf.getRootElement();
		//获取端口配置信息
		port = rootElement.elementText("Honeypot-port");
		//获取日志文件配置信息
		log = rootElement.elementText("Honeypot-log");
		//添加端口和配置文件信息
		result.add(port);
		result.add(log);
		return result;
	}
}
