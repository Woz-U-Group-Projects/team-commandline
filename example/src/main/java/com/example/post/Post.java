package com.example.post;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	
	//Basic Properties
	private String content;
	private String name;
	private int date;
	
	//Overloaded Constructor 
	public Post(String content, String name, int date) {
		this.content = content;
		this.name = name;
		this.date = date;
	}
	//General Constructor
	public Post() {
		content = "";
		name = "";
		date = 01012000;
	}
	
	//Getters
	public String getContent() {
		return content;
	}
	public String getName() {
		return name;
	}
	public int getDate() {
		return date;
	}
	public long getId() {
		return id;
	}
	
	//Setters
	public void setContent(String content) {
		this.content = content;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setId(long id) {
		this.id = id;
	}
}
