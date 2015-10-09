package com.hack4b;

import java.io.IOException;
import java.net.ServerSocket;

import org.dom4j.DocumentException;

/**
 * 本来提供端口监听的功能
 * @author on ice
 *
 */
public class ListenPortAction {
	
	/**
	 * 本地主机socket
	 */
	ServerSocket[] localHost = null;
	
	/**
	 * 打开端口监听
	 * @throws DocumentException
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void startListen() throws DocumentException, NumberFormatException, IOException{
		//初始化配置文件阅读器
		ConfReader confReader = new ConfReader();
		//获取端口号
		String[] port = confReader.getPort();
		//根据端口创建ServerSocket对象
		for(int i = 0;i<port.length;i++){
			localHost[i] = new ServerSocket(Integer.parseInt(port[i]));
		}
		while(true){
			//TODO 端口监听实现体
		}
	}
}
