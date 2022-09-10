package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.service.DBTestService;

@Controller
public class HomeController {
	
	@Autowired	// 스프링 빈 중에서 타입이 일치하는 객체를 자동으로 맵핑한다 (의존 주입)
	private DBTestService ds;// = new DBTestService();

	@RequestMapping("/")	// 요청 메서드에 상관없이 주소만으로 판별하려면 RequestMapping으로 처리하면 된다
	public String home(Model model) {

		String msg = ds.getTest();
		model.addAttribute("msg", msg);
		return "home";
	}
}
