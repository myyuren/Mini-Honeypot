package com.hack4b;

import java.io.File;
import java.io.FileWriter;
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
	
	FileWriter fw = null;
	
	PrintWriter pw = null;
	
	/**
	 * 打开日志文件，并获得输出流
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void openLogFile(){
		//创建配置文件阅读器对象
		ConfReader confReader;
		try {
			confReader = new ConfReader();
			//获取日志文件路径
			logFile = new File(confReader.getLog());
			//如果文件不存在，则创建
			if(logFile.exists()==false){
				logFile.createNewFile();
			}
			fw = new FileWriter(logFile,true);
			pw = new PrintWriter(fw);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 写入日志文件
	 * @param info
	 * @throws IOException 
	 */
	public void writeLog(String info) throws IOException{
		pw = new PrintWriter(fw);
		pw.println(info);
	}
	
	/**
	 * 清空缓存并关闭输出流
	 */
	public void closeLogFile(){
		try {
			fw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
