package com.hack4b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.dom4j.DocumentException;

/**
 * 该类提供日志的写入操作
 * @author on ice
 *
 */
public class LogAction {
	
	File logFile = null;
	
	PrintWriter pw = null;
	
	public LogAction() throws DocumentException, IOException {
		//创建配置文件阅读器对象
		ConfReader confReader = new ConfReader();
		//获取日志文件路径
		logFile = new File(confReader.getLog());
		//如果文件不存在，则创建
		if(logFile.exists()==false){
			logFile.createNewFile();
		}
	}
	
	/**
	 * 写入日志文件
	 * @param info
	 * @throws FileNotFoundException
	 */
	public void writeLog(String info) throws FileNotFoundException{
		pw = new PrintWriter(logFile);
		pw.write(info);
		pw.close();
	}
}
