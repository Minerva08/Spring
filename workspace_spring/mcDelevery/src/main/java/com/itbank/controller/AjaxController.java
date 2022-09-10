package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.TestDTO;
import com.itbank.service.TestService;

@RestController
public class AjaxController {

	@Autowired private TestService ts;
	
	@GetMapping("/ajaxProductList")
	public List<TestDTO> ajaxProductList() {
		return ts.getList();
	}
}
