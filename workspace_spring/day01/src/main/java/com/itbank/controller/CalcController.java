package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {
	@GetMapping("/calc")
	public void safd() {}
	
	@PostMapping("/calc")
	public ModelAndView calc(CalcDTO dto) {
		switch(dto.getOp()) {
		case "+":
			dto.setResult(dto.getN1()+dto.getN2());
			break;
		case "-":
			dto.setResult(dto.getN1()-dto.getN2());
			break;
		case "*":
			dto.setResult(dto.getN1()*dto.getN2());
			break;
		case "/":
			dto.setResult(dto.getN1()/dto.getN2());
			break;
		}
		
		
		ModelAndView mav = new ModelAndView("calc");
		mav.addObject("dto",dto);
		
		return mav;
	}
	
}
