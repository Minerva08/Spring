package test;

import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> formData = new HashMap<String, String>();
		
		formData.put("title", "자동차 정비");
		formData.put("content", "탄소");
		formData.put("tdate", "2021-12-28");
		
		for(String key : formData.keySet()) {
			System.out.println(key + ", " + formData.get(key));
		}
		
		System.out.println(formData.toString());
		
	}
}
