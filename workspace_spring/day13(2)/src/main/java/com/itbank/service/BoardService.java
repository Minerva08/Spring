package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.board.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;

	public List<HashMap<String, Object>> getBoardData(int offset) {
		return dao.selectBoardData(offset);
	}

	public int writeBoard(HashMap<String, String> map) {
		return dao.insertBoardData(map);
	}
}
