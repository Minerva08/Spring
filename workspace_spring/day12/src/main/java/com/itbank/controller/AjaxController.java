package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

//@Controller

@RestController // ajax요청을 전문적으로 처리하는 컨트롤러
				// 하위 모든 메서드는 @ResponseBody를 명시하지 않아도 처리하게 된다
public class AjaxController {
	@Autowired
	private MemberService ms;

	@GetMapping("/ajax1")
//	@ResponseBody		//반환하는 데이터 그대로 응답으로 보내주기
	public String ajax1() {
		return "Hello, World!!";
	}

	@GetMapping("/ajax2")
	@ResponseBody
	public int ajax2(String ch) {
		int code = (int) ch.charAt(0);
		return code;
	}

	@GetMapping(value = "/ajax3", produces = "application/json; charset=utf-8")
//	@ResponseBody
	public String ajax3(String userid) throws JsonProcessingException {
		MemberDTO dto = ms.getMember(userid);
		ObjectMapper om = new ObjectMapper(); // 자바 <->자바스크립트 객체 변환기
		String json = om.writeValueAsString(dto);// 객체의 값을 문자열 형식으로
		return json;
	}

	@GetMapping("/ajax4")
//	@ResponseBody
	public List<MemberDTO> ajax4() {
		return ms.getMemberList();
	}

	@GetMapping(value = "/ajax5", produces = "application/json; charset=utf-8")
//	@ResponseBody
	public List<MemberDTO> ajax5(String username) {
		return ms.getMemberListByUsername(username);
	}

	
//  @GetMapping("/ajax6") 
//  public boolean quiz2(String userid){ 
//	  MemberDTO dto =ms.getMember(userid); 
//	  if(dto==null) { 
//		  System.out.println(1);
//	  	  return true; 
//	  }
//	  else {
//		  System.out.println(0); 
//		  return false ; 
//	  }
//  }
	 

	@GetMapping("/idcheck/{userid}")
	public HashMap<String, String> idcheck(@PathVariable String userid){
		HashMap<String ,String> map = new HashMap<String,String>();
		System.out.println(userid);
		MemberDTO dto =ms.getMember(userid);
		
		map.put("msg",dto==null ? "사용가능한 ID입니다.":"이미 사용중인 ID입니다.");
		map.put("color", dto==null ?"blue":"red");
		map.put("focus",dto==null ?"userpw":"userid");
		System.out.println(map);
		return map;
	}
	

}
