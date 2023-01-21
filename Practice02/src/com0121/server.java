package com0121;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Chat implements Runnable {
	@Override
	public void run() {
		ServerSocket server = null;
		Socket client = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		ArrayList<Socket> clientSet = new ArrayList<>();
		
		while(true) {
			try {
				server = new ServerSocket(8000);
				client = server.accept();
				clientSet.add(client);
				System.out.println("클라이언트 접속!");
				
				os = client.getOutputStream();
				osw = new OutputStreamWriter(os);
				
				osw.write("hello world");
				osw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(client != null) client.close();
					if(server != null) server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		
	}
}

public class server {

	public static void main(String[] args) {
		Thread thr = new Thread(new Chat());
		thr.start();

	}

}
