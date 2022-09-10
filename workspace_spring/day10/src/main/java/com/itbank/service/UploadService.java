package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.image.UploadDAO;
import com.itbank.image.UploadDTO;

@Service
public class UploadService {
	
	private File dir = new File("D:\\upload");
	
	
	
	@Autowired	// DAO가 인터페이스라면 DAO를 구현한 익명 프록시 객체가 스프링 빈으로 등록된다
	private UploadDAO dao;

	public List<UploadDTO> getList() {
		return dao.selectList();
	}

	public int upload(UploadDTO dto) throws IllegalStateException, IOException {
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		System.out.println(dto.getUploadFile());
		// 위 출력문이 null이면 파일이 안들어왔다는 말이니까 파일업로드 관련 multipartResolver 객체가 있는지 확인한다
		// 있으면 pom.xml 에서 업로드 관련 라이브러리 의존성이 작성되어 있는지 확인한다
		
		String originalFileName = dto.getUploadFile().getOriginalFilename();
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "");
		String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		storedFileName += extName;
		
		dto.setOriginalFileName(originalFileName);
		dto.setStoredFileName(storedFileName);
		
		File dest = new File(dir, storedFileName);
		dto.getUploadFile().transferTo(dest);
		
		return dao.insert(dto);
	}

}






