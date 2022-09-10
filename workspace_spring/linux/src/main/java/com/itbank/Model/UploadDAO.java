package com.itbank.Model;

import org.apache.ibatis.annotations.Insert;

public interface UploadDAO {
	@Insert("insert into sftp values(#{uploadFilePath})")
	public int insert(SftpDTO dto);
}
