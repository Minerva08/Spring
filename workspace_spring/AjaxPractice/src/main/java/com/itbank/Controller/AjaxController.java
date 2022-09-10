package com.itbank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.Service.TodoService;
import com.itbank.todo.TodoDTO;

@RestController
public class AjaxController {
	@Autowired private TodoService ts;
	
	@GetMapping("/todo")
	public List<TodoDTO> todoList(){
		
	List<TodoDTO> list = ts.getList();
		return list;
	}
	
}
