package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.service.FileService;

@Controller
public class HomeController {
	
	@Autowired private FileService fs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String home(MultipartFile file) throws IllegalStateException, IOException {	
									// 파일을 매개변수로 받아서 처리
		System.out.println(file);
		System.out.println(file.getName());		// 	<input type="file" name="file">
		System.out.println(file.getOriginalFilename());	// 관대하.jpg
		System.out.println(file.getContentType());		// image/jpeg
		System.out.println(file.getSize());				// 파일 용량 (byte)
		System.out.println();
		
		boolean isUploaded = fs.upload(file);
		System.out.println(isUploaded ? "성공" : "실패");
		
		return "redirect:/";
	}
	
}
