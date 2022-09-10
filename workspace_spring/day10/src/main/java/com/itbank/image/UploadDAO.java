package com.itbank.image;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository	// 생략해도 작동은 되지만, 명시적인 표현 + 예외 처리를 위해서 작성한다
public interface UploadDAO {

	@Select("select * from image2 order by uploadDate")
	List<UploadDTO> selectList();

	@Insert("insert into image2 (originalFileName, storedFileName, uploadUser) " + 
			"    values (#{originalFileName}, #{storedFileName}, #{uploadUser})") 
	int insert(UploadDTO dto);

}
