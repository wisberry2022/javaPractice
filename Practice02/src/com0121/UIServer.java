package com0121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class UIServer extends Thread{
	
	private Socket sock = null;
	private static ArrayList<Socket> clients = new ArrayList<Socket>();
	
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader fromClient = null;
	OutputStream os = null;
	OutputStreamWriter osw = null;
	PrintWriter toClient = null;
	
	public UIServer(Socket sock) {
		this.sock = sock;
		clients.add(sock);
	}
	
	@Override
	public void run() {
		System.out.println(sock + ": 클라이언트 접속!" + currentThread().getName());
		try {
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			fromClient = new BufferedReader(isr);
			
			String msg = "";
			while(true) {
				msg = fromClient.readLine();
				for(int i = 0; i<clients.size(); i++) {
					os = clients.get(i).getOutputStream();
					osw = new OutputStreamWriter(os);
					toClient = new PrintWriter(osw);		
						
					toClient.println(msg);
					toClient.flush();	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(toClient != null) toClient.close();
				if(osw != null) osw.close();
				if(os != null) os.close();
				if(fromClient != null) fromClient.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			}catch(IOException e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSock = new ServerSocket(8080);
			
			while(true) {
				Socket client = serverSock.accept();
				UIServer myServer = new UIServer(client);
				myServer.start();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
