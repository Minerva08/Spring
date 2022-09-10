package com.itbank.Service;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.Model.SftpDTO;
import com.itbank.Model.UploadDAO;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Service
public class UploadService {
	private final String serverIP="192.168.122.1";
	private final int serverPort=22;
	private final String serverUser="root";
	private final String serverPass="1";
	private final String chSftp=null;
	
	@Autowired private UploadDAO dao;
	
	
	public String upload(SftpDTO dto) throws Exception {
		//1) 업로드 받은 파일을 임시파일로 웹 서버에 저장
		MultipartFile file = dto.getUploadFile();
		File dest = new File(file.getOriginalFilename());
		
		file.transferTo(dest);
		
		
		//
		Session sess=null;
		Channel channel = null;
		JSch jsch= new JSch();
		sess = jsch.getSession(serverUser,serverIP,serverPort);
		sess.setPassword(serverPass);
		sess.setConfig("StrictHostKeyChecking","no");
		sess.connect();
		
		channel= sess.openChannel("sftp");
		channel.connect();
		
		chSftp = (ChannelSftp) channel;
		FileInputStream fis = new FileInputStream(dest);
		chSftp.cd("/var/www/html");
		chSftp.put(fis,dest.getName());
		
		fis.close();
		chSftp.exit();
		
		String uploadFilePath="";
		uploadFilePath+="http://";
		uploadFilePath+=serverIP;
		uploadFilePath+=":1234";
		uploadFilePath+="/"+dest.getName();
		
		dto.setUploadFilePath(uploadFilePath);
		
		
		int row=dao.insert(dto);
		dest.delete();
		return row==1? dto.getUploadFilePath():null;
		
		
		
		return null;
	}

}
