package com.itbank.image;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

//	create table image2 (
//		originalFileName	varchar2(255)	not null,
//		storedFileName		varchar2(255) 	not null,
//		uploadDate			date			default sysdate,
//		uploadUser			varchar2(100)	not null,	
//	
//		constraint image2_member_fk 	--생성할 외래키 규칙 이름
//		foreign key(uploadUser)			--외래키로 지정할 컬럼
//		references member(userid)		--외래키가 참조할 대상
//		on delete cascade				--삭제 시 처리방침
//	);

public class UploadDTO {
	private String originalFileName;
	private String storedFileName;
	private Date uploadDate;
	private String uploadUser;
	private MultipartFile uploadFile;	// form에서 전송하는 파일을 받기 위해서
	
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getUploadUser() {
		return uploadUser;
	}
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
}
