package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.TestDAO;
import com.itbank.model.TestDTO;

@Service
public class FileService {
	
	@Autowired private TestDAO dao;

	// 프로젝트 내부 경로가 아닌, 별도의 경로에 파일을 모아둔다 (업로드 수가 많아져도 프로젝트는 영향이 없다)
	private String uploadPath = "/upload";
	private File dir;
	
	public FileService() {
		dir = new File(uploadPath);
		if(dir.exists() == false) {
			System.out.println("폴더가 없어서 새로 생성함");
			dir.mkdirs();
		}
	}
	
	public boolean upload(MultipartFile file) throws IllegalStateException, IOException {
		File dest = new File(dir, file.getOriginalFilename());
		// new File(폴더위치, 파일이름);
		
		file.transferTo(dest);	// MultipartFile을 File 형태로 변경하면서 업로드
		
		return dest.exists() && dest.isFile();	// 대상이 존재하고, 형식이 파일이면 true
	}

	public int upload2(TestDTO dto) throws IllegalStateException, IOException {
		// 1) 실제 업로드하고, DB에 저장할 파일이름부터 결정하자
		// 여기서는 날짜를 활용한다
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		String fileName = dto.getUploadFile().getOriginalFilename();
		fileName = today + "_" + fileName;
		
		// 2) 결정된 이름으로 파일을 업로드 한다
		File dest = new File(dir, fileName);
		dto.getUploadFile().transferTo(dest);
		
		// 3) DB에 기록해야 하니 결정된 파일 이름을 dto에 세팅한다
		dto.setFileName(fileName);
		
		// 4) DAO에 넘어갔다면 쿼리문을 만들어줄때 fileName을 사용하면 된다
		String sql = "insert into TABLE values ('%s', %s, '%s')";
		sql = String.format(sql, dto.getName(), dto.getAge(), dto.getFileName());
		System.out.println(sql);
		
//		String extName = fileName.substring(fileName.indexOf("."));
//		System.out.println("확장자 : " + extName);
		
		// 5) DB에 저장하는 대신 리스트에 저장해보자
		int row = dao.insert(dto);
		
		return row;
	}

	public List<TestDTO> selectList() {
		return dao.selectList();
	}
}













