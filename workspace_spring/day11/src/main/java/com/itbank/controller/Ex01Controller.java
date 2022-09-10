package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	@GetMapping("/ex01")
	public void ex01() {}
	
	@GetMapping("/ex01-ajax")
	@ResponseBody//이 메소드는 으답의 내용을 직접 반환합니다.
	public String ex01Ajax() {
		return "ex01";//ex01.jsp를 찾아가서 실행하고 그 결과를 response로 반환한다
		//반환하는 문자열 자체가 응답이 되지 않는다
		//return "Hello, world";
	}

}
