package com.itbank.member;
//userid        varchar2(50)        primary key,
//userpw        varchar2(50)          not null,
//username      varchar2(100)         not null,
//email         varchar2(100)         not null,
//address       varchar2(100)         not null
public class Memberdto {
	private String userid, userpw, username, email, address;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
