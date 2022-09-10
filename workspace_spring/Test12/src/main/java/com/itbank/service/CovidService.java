package com.itbank.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CovidService {
	
	private final String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";
	private final String url1="https://api.odcloud.kr/api/15077756/v1/vaccine-stat";
	private final String servicekey1 = "GEUhUxSO%2Bjvcfq6CUcBdlbPvTaGZOunL3C%2FIGVMguG%2F5Dm9Bl7tXeITod5ABHKYKmQ2jKwbbpRDXVBTUhVkkGQ%3D%3D";
	private final String serviceKey = "GEUhUxSO%2Bjvcfq6CUcBdlbPvTaGZOunL3C%2FIGVMguG%2F5Dm9Bl7tXeITod5ABHKYKmQ2jKwbbpRDXVBTUhVkkGQ%3D%3D";

	public String getData() throws IOException {
		
		Date dDate = new Date();
		dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
		SimpleDateFormat dSdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String yesterday = dSdf.format(dDate);

		String startday = "20220101";
		
		
		
		String queryString = "?";
		queryString += "serviceKey=" 	+ serviceKey 	+ "&";
		queryString += "pageNo=" 		+ 1 			+ "&";
		queryString += "numOfRows=" 	+ 10 			+ "&";
		queryString += "startCreateDt=" + startday 		+ "&";
		queryString += "endCreateDt=" 	+ yesterday 		+ "&";
		
		
		
		
		URL requestURL = new URL(url+queryString);
		HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		
		Scanner sc = null;
		String xmlData = "";
		
		if(conn.getResponseCode() == 200) {
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				xmlData += sc.nextLine();
			}
			sc.close();
			conn.disconnect();
			return xmlData;
		}
		return null;
	}
	
	


	public String getVaccine() throws IOException {
		
		SimpleDateFormat ssdf = new SimpleDateFormat("yyyy-MM-01");
		SimpleDateFormat esdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date today = new Date();
		Date yesterday = new Date(today.getTime()-1000*60*60*24);
		
		String startDay = ssdf.format(today); 
		String endDay = esdf.format(yesterday); 
		
		HashMap<String,String> param = new HashMap<String, String>();
		param.put("page","1");
		param.put("perPage","31");
		param.put("cond[baseDate::GTE]", startDay);
		param.put("cond[baseDate::LTE]", endDay);
		param.put("cond[sido::EQ]","부산광역시");
		
		String queryString = "?";
		for(String key : param.keySet()) {
			String value = param.get(key);
			key = URLEncoder.encode(key, "UTF-8");		//파라미터 이름이나 값에 한글 및 특문이 들어가면
			value = URLEncoder.encode(value, "UTF-8");	//URL Encoding 처리해야한다
			queryString += key + "=" + value + "&";
		}
		queryString += "serviceKey=" + servicekey1;
		
		System.out.println(url1 +queryString);
		URL requestURL = new URL(url1 + queryString);
		HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		
		Scanner sc = null;
		String data = "";
		
		if(conn.getResponseCode() == 200) {
			sc = new Scanner(conn.getInputStream());
			while(sc.hasNextLine()) {
				data += sc.nextLine();
			}
			sc.close();
			conn.disconnect();
			return data;
		}
		return null;
	}
	
	
}
