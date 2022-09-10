package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.model.TestDTO;
import com.itbank.service.TestService;

@Controller
public class HomeController {
	
	@Autowired private TestService ts;
	
	@GetMapping("/")
	public String home() {
//		List<TestDTO> list = ts.getList();
//		for(TestDTO dto : list) {
//			System.out.println(dto.getName());
//			System.out.println(dto.getImg() != null);
//			System.out.println(dto.getPrice());
//			System.out.println(dto.getKcal());
//			System.out.println();
//		}
		return "home";
	}
}