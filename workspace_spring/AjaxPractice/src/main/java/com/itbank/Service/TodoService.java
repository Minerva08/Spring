package com.itbank.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.todo.TodoDAO;
import com.itbank.todo.TodoDTO;

@Service
public class TodoService {
	@Autowired private TodoDAO dao;

	public List<TodoDTO> getList() {
		return dao.getList();
	}
	
}
