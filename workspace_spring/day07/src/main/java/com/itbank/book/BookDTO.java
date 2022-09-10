package com.itbank.book;

import java.sql.Date;

//  TABLE : BOOK
//	IDX			NUMBER				No	"C##ITBANK"."BOOK_SEQ"."NEXTVAL"
//	NAME		VARCHAR2(200 BYTE)	No	
//	AUTHOR		VARCHAR2(50 BYTE)	No	
//	PUBLISHER	VARCHAR2(100 BYTE)	No	
//	PUBLISHDATE	DATE				No	
//	PRICE		NUMBER				No	
//	DESCRIPTION	VARCHAR2(2000 BYTE)	No	

public class BookDTO {

	private int idx;
	private String name, author, publisher;
	private Date publishDate;
	private int price;
	private String description;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
