package com0121;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UIClient2 extends Frame {
	static TextArea chatWindow = new TextArea();
	static TextField chatter = new TextField();
	
	public UIClient2() {
		setBounds(500, 500, 500, 500);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setLayout(new BorderLayout());
		
		add(chatWindow, BorderLayout.CENTER);
		add(chatter, BorderLayout.SOUTH);		
	}
	
	public static void main(String[] args) {
		UIClient2 client = new UIClient2();
		Socket sock = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		
		try {
			sock = new Socket(InetAddress.getLocalHost(), 8080);
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			os = sock.getOutputStream();
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);
			
			while(true) {
				String total = "";
				while(true) {
					String msg = br.readLine();
					System.out.println(msg);
					String[] parsed = msg.split(":");
					total += parsed[1];
					chatWindow.append(total);
					if(parsed[parsed.length-1].equals("--end")) break;
				}	
				break;
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
		
		
	}

}
