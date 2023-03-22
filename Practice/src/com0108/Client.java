package com0108;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Socket client = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		try {
			client = new Socket(InetAddress.getLocalHost(), 8000);
			
			os = client.getOutputStream();
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);
			
			
			String msg;
			while(true) {
				msg = sc.next();
				if(msg.equals("exit")) break;
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw != null) pw.close();
				if(osw != null) osw.close();
				if(os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
