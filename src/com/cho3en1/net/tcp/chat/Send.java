package com.cho3en1.net.tcp.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ��������
 * @author ӣ����
 *
 */
public class Send implements Runnable {
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�����߳�
	private boolean isRunning = true;
	
	public Send() {
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	//1���ӿ���̨��������
	private String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			
		}
		return "";
	}
	/**
	 * 1���ӿ���̨��������
	 * 2����������
	 */
	public void send() {
		String msg = getMsgFromConsole();
		if(msg != null && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				isRunning = false;
				CloseUtil.closeAll(dos,console);
			}
		}
	}
	
	@Override
	public void run() {
		//�߳���
		while(isRunning) {
			send();
		}
	}
	
}
