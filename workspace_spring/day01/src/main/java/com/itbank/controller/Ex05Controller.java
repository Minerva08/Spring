package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex05Controller {

        @GetMapping("/ex05")
        public void ex05() {}
        
        @GetMapping("/ex05/{name}")
        public ModelAndView ex05(@PathVariable String name) {
                ModelAndView mav = new ModelAndView("ex05");
                mav.addObject("msg", "안녕하세요, " + name);
                return mav;
        }
        
        // @PathVariable : 경로 변수, 요청 주소에 일부분을 파라미터로 취급하여 받을 수 있다
        // GET 요청시 파라미터의 표현방식인 쿼리스트링을 대체할 수 있다
}
