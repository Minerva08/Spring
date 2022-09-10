package com.itbank.controller;


//스프링 빈은 싱글톤인데,
//DTO는 서로 다른 값을 가지는 여러 객체가 존재헤야 하므로 스프링 빈으로 등록 하지 않는다

public class MemberDTO {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
