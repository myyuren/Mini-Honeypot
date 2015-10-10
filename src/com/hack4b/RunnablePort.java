package com.hack4b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.dom4j.DocumentException;

/**
 * 本类提供端口监听的线程操作
 * @author on ice
 *
 */
public class RunnablePort implements Runnable {

	/**
	 * 本地主机Socket
	 */
	ServerSocket localHost = null;
	
	public RunnablePort(ServerSocket localHost) {
		this.localHost = localHost;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				//获取远程客户端
				Socket remote = localHost.accept();
				//获取远程客户端的IP地址
				String remoteIP = remote.getLocalAddress().getHostAddress();
				//获取远程客户端的主机名
				String remoteHostName = remote.getLocalAddress().getHostName();
				//写入日志
				new LogAction().writeLog("主机名："+remoteHostName+"--IP地址："+remoteIP);
				//关闭连接
				remote.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
