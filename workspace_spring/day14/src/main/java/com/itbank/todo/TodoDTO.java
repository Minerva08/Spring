package com.itbank.todo;

import java.sql.Date;

//	create table todo (
//		idx			number			default todo_seq.nextval primary key,
//		title		varchar2(100)	not null,
//		content		varchar2(500)	not null,
//		tdate		date			not null
//	);

public class TodoDTO {
	private int idx;
	private String title;
	private String content;
	private Date tdate;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %s %s %s",idx,title,content,tdate);
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
	
}
