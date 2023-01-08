package com0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			serverSocket = new ServerSocket(8000);
			Socket sock = serverSocket.accept();
			System.out.println("클라이언트 접속!");
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String msg;
			int su;
			
			while(true) {
//				su = isr.read();
//				System.out.print((char)su);
				msg = br.readLine();
				if(msg.equals("exit")) break;
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("접속 종료!");
	}

}
