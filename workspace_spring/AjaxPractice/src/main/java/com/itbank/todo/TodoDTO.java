package com.itbank.todo;

import java.util.Date;

public class TodoDTO {
	private int IDX;       
	private String TITLE; 
	private String CONTENT; 
	private Date TDATE;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Date getTDATE() {
		return TDATE;
	}
	public void setTDATE(Date tDATE) {
		TDATE = tDATE;
	}
	
	
	

}
