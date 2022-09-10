package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

	// 자바 코드를 활용하여 내 웹서버에서 다른 서버의 json 데이터를 받아오기
	public String getMemberList() throws IOException {
		String url = "http://221.164.9.200/memberList";
		
		URL requestURL = new URL(url);	// 요청할 주소
		HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		
		Scanner sc = null;
		String json = "";
		
		if(conn.getResponseCode() == 200) {	// 요청 결과 응답이 200 OK 정상이면
			sc = new Scanner(conn.getInputStream());	// 응답을 읽어낼 수 있는 스트림
			while(sc.hasNextLine()) {		// 다음 줄이 있으면
				json += sc.nextLine();		// 한 줄씩 json 문자열에 더한다
			}
			sc.close();						// 내용을 모두 가져왔으면 스트림 닫기
			conn.disconnect();				// HTTP 연결 닫기
			return json;					// 결과 반환
		}
		return null;	// 응답 코드가 정상이 아니면 반환값이 없음
	}

}
