package com.itbank.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex02Controller {
	@GetMapping("/ex02")
	public void ex02() {}
	
	@GetMapping("/ex02Ajax")
	@ResponseBody
	public int ex02Ajax(@RequestParam HashMap<String, String> param) {
		System.out.println(param);
		int n1 = Integer.parseInt(param.get("n1"));
		int n2 = Integer.parseInt(param.get("n2"));
		int answer=n1+n2;
		return answer;
	}
	
}
