package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;



@Service
public class BoardService {
	@Autowired private BoardDAO bdao;

}
