package com.example.groupproject.models;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="Posts")
public class Post {
	@Id
	@GeneratedValue
	//Basic properties
	private String content;
	private String name;
	private int id;
	
	
	//overloaded constructor
	public Post(String content, String name, int id) {
		this.content = content;
		this.name = name;
		this.id = id;
	}
	//general constructor
	public Post() {
		content = "";
		name = "";
		id = 0;
	}

}
