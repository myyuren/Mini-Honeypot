package com.hack4b;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

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
				//获取日志写入器
				LogAction logAction = new LogAction();
				//打开日志文件
				logAction.openLogFile();
				//等待远程主机连接
				Socket remote = localHost.accept();
				//获取远程主机的IP地址
				String remoteIP = remote.getInetAddress().getHostAddress();
				//获取远程主机的主机名
				String remoteHostName = remote.getInetAddress().getHostName();
				//获取主机名失败
				if(remoteIP.equals(remoteHostName)){
					remoteHostName = "主机名未知";
				}
				//获取被攻击端口号
				int localPort = remote.getLocalPort();
				//获取时间
				String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
				//写入日志
				String logLine = "发现目标："+remoteHostName+" IP地址："+remoteIP+" 攻击端口："+localPort+" 时间："+date;
				logAction.writeLog(logLine);
				//关闭日志文件
				logAction.closeLogFile();
				//将远程主机信息显示到控制台
				System.out.println(logLine);
				//获取远程主机的输出流
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(remote.getOutputStream()));
				//创建配置文件读取器
				ConfReader cfgReader = new ConfReader();
				//获取配置文件消息
				String message = cfgReader.getMessage();
				//如果消息不为空，发送消息给远程主机
				if(!"".equals(message)&&message!=null){
					pw.write(message);
				}
				//刷新缓冲区
				pw.flush();
				//关闭输出流
				pw.close();
				//关闭远程主机连接
				if(remote.isConnected()){
					remote.close();
				}
			} catch (IOException e) {
				System.err.println("抱歉，程序出了点问题，需要你重启下。");
				return;
			} catch (DocumentException e) {
				System.err.println("配置文件未找到！");
				return;
			}
		}
		
	}
}
