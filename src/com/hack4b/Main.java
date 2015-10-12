package com.hack4b;

import java.io.IOException;

import org.dom4j.DocumentException;

/**
 * 程序入口
 * @author on ice
 *
 */
public class Main {
	public static void main(String[] args) {
		try {
			//开启端口监听
			new ListenPortAction().startListen();
			System.out.println("已经开始工作了……");
			System.out.println("所有的攻击都会显示在本窗口上并写入日志。  -- on ice");
		} catch (NumberFormatException | DocumentException | IOException e) {
			e.printStackTrace();
			System.err.println("抱歉，程序出了点错误，需要你重启下- -!");
		}
	}
}
