package com.cho3en1.net.tcp.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * �ر����ķ���
 * @author ӣ����
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
