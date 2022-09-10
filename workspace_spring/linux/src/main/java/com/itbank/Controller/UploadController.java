package com.itbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.Model.SftpDTO;
import com.itbank.Service.UploadService;

@Controller
public class UploadController {
	@Autowired UploadService us;
	@PostMapping("upload")
	public String upload(SftpDTO dto) throws Exception {
		System.out.println(dto.getUploadFile().getOriginalFilename());
		String uploadFilePath = us.upload(dto);
		return "redirect:/";
	}
}
