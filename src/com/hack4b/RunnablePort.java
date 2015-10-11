package com.hack4b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


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
				//获取远程主机
				Socket remote = localHost.accept();
				//获取远程主机的IP地址
				String remoteIP = remote.getInetAddress().getHostAddress();
				//获取远程主机的主机名
				String remoteHostName = remote.getInetAddress().getHostName();
				//获取远程主机的端口号
				int remotePort = remote.getLocalPort();
				//获取日志操作对象
				LogAction logAction = new LogAction();
				//打开日志文件
				logAction.openLogFile();
				//写入日志
				logAction.writeLog("主机名："+remoteHostName+"--IP地址："+remoteIP+":"+remotePort);
				//关闭日志文件
				logAction.closeLogFile();
				//关闭远程主机连接
				remote.close();
			} catch (IOException e) {
				System.err.println("抱歉，程序出了点问题，需要你重启下 - -!");
				return;
			}
		}
		
	}

}
