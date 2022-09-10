package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex02Controller {

        @GetMapping("/ex02")        // @RequestMapping(value="/ex02", method=RequestMethod.GET)
        public String ex02() {
                return "ex02";
        }
        
        @PostMapping("/ex02")        // @GetMapping, @PostMapping 등은 스프링 4.1.0 이상부터 가능
        public String ex02(@ModelAttribute("name") String name, @RequestParam int age, Model model) {
                
                String adult = age >= 20 ? "성인" : "미성년자";
                
//                model.addAttribute("name", name);
                model.addAttribute("age", age);
                model.addAttribute("adult", adult);        // request.setAttribute("adult", adult);
                
                return "ex02Result";
        }
        // @RequestParam : request.getParameter(변수이름) => 생략가능
        // @ModelAttribute : 파라미터 그대로 model에 attribute로 등록하기, 파라미터 이름을 명시해주기
}
