package com.hack4b;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

import org.dom4j.DocumentException;

/**
 * 端口监听器
 * @author on ice
 *
 */
public class ListenPortAction{
	
	/**
	 * 本地主机socket
	 */
	ServerSocket[] localHost = null;
	/**
	 * 端口监听线程
	 */
	Thread[] portThread = null;
	
	/**
	 * 打开端口监听
	 * @throws DocumentException
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void startListen() throws DocumentException, NumberFormatException, IOException{
		//初始化配置文件读取器
		ConfReader confReader = new ConfReader();
		//获取端口号
		String[] portString = confReader.getPort();
		//根据端口创建ServerSocket对象
		localHost = new ServerSocket[portString.length];
		for(int i = 0;i<portString.length;i++){
			try {
				localHost[i] = new ServerSocket(Integer.parseInt(portString[i]));
			} catch (BindException e) {
				System.err.println("端口冲突！请检查配置文件与当前的端口使用情况！");
				return;
			}
		}
		//根据端口创建线程并启动
		portThread = new Thread[portString.length];
		for(int i = 0;i<portString.length;i++){
			portThread[i] = new Thread(new RunnablePort(localHost[i]));
			portThread[i].start();
		}
	}
}
