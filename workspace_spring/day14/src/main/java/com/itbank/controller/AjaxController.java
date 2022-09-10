package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.service.TodoService;
import com.itbank.todo.TodoDTO;

@RestController		// 모든 메서드는 @ResponseBody를 포함한다
					// @ResponseBody : 이 함수가 반환하는 값 그 자체가 응답이다(포워딩하지 않는다)
public class AjaxController {
	
	@Autowired private TodoService ts;

	@GetMapping("/todo")
	public List<TodoDTO> selectList() {
		for(TodoDTO todolist:ts.selectList()) {
			System.out.println(todolist);
		};
		return ts.selectList();
	}
	
	@PostMapping("/todo")
	public int insertTodo(@RequestBody TodoDTO dto) {
		// @RequestBody : 요청에 담긴 [ body: JSON.stringify(ob) ] 를 dto에 맵핑한다
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getContent());
//		System.out.println(dto.getTdate());
		return ts.insert(dto);
	}
	
	@DeleteMapping("/todo/{idx}")
	public int deleteTodo(@PathVariable int idx) {
		return ts.getDelete(idx);	// return ts.delete(idx);
	}
}
