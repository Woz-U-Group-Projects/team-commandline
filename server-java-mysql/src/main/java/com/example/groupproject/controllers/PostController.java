package com.example.groupproject.controllers;
import com.groupproject.dao.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PostController {
	@Autowired
	private PostDao dao;
	
	//Create
	public String createPost() {
		return "This will create a new post";
	}
	
	//Read
	public String getPost() {
		return "Get Post Method";
	}
	
	//Update
	public String updatePost() {
		return "This will need to get the existing poost and edit it";
	}
	
	//Delete
	public String deletePost() {
		return "This will need to take in a post by Id as a paramater and delete it";
	}
}
