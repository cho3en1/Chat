package com.cho3en1.net.tcp.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 * @author 樱满集
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io) {
		for(Closeable temp:io) {
			try {
				if(null != temp) {
					temp.close();
				}
			} catch (IOException e) {
				
			}
		}
	}
}
