package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//스프링에서 컨트롤러의 개수는 상관 없다
//작성자 기준으로 관련있는 주소끼리 모아서 하나의 컨트롤러로 제어하면 된다
//여러개의 컨트롤러가 있어도 서블릿의 관심사는 어떤 RequestMapping이 있는가이다

@Controller
public class Ex01Controller {
	
	@RequestMapping(value="/ex01", method=RequestMethod.GET)
	public String ex01() {
		return "ex01";
	}
	
	//컨트롤러는 DispatcherServlet에게 요청을 넘겨받으므로
	//DispatcherServlet이 넘겨줄 수 있는 값을 함수의 매개변수에 작성하면 된다
	@RequestMapping(value="/ex01", method=RequestMethod.POST)
	public String ex01(HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		String adult=age >=20? "성인":"미성년자";
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("adult", adult);
		return "ex01Result";
	}
}
