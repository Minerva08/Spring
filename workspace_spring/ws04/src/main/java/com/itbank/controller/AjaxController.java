package com.itbank.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.chat.ChatComponent;

@RestController
public class AjaxController {

	@Autowired private ChatComponent cc;
	
	@GetMapping(value="/loadPeople",produces="application/json;charset=utf-8")
	public Set<String> loadPeople() {
		return cc.getSessionMap().keySet();
	}
	
}
