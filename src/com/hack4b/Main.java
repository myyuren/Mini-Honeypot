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
		} catch (NumberFormatException | DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
