package com0121;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client2 {

	public static void main(String[] args) {
		Socket sock = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		InputStreamReader isr = null;
		
		try {
			sock = new Socket(InetAddress.getLocalHost(), 8000);
			System.out.println("서버 접속!");
			is = sock.getInputStream();
			bis = new BufferedInputStream(is);
			isr = new InputStreamReader(bis);
			
			int su;
			ArrayList<Byte> arr = new ArrayList<>();
			while(true) {
				su = isr.read();
				if(su == -1) break;
				arr.add((byte)su);
			}
			
			byte[] bytearr = new byte[arr.size()];
			
			for(int i = 0; i<bytearr.length; i++) {
				bytearr[i] = arr.get(i);
			}
			
			System.out.println(new String(bytearr));
			
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				if(bis != null) bis.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
