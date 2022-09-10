package com.itbank.service;

import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	public String getText() throws IOException {
		
		URL url = new URL("http://192.168.1.100:1234/notice/포인트보상정책.txt"); 
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		
		
		String text  ="";
		Scanner sc = null;

		if(conn.getResponseCode() == 200) {
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNext()) {
				text += sc.nextLine()+"\n";
			}
			sc.close();
			conn.disconnect();
			return text;
		}
		return null;
	}

}
