package com.example.groupproject.controllers;
import com.groupproject.dao.*;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.groupproject.models.Post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@RestController
public class PostController {
	@Autowired
	private PostDao dao;
	
	//Create
	public String createPost(String postContent, String name, int date) {
		//executeUpdate("INSERT INTO Posts (name, content) VALUES (name, postContent);");
		//close();
		return "New post created: " + postContent;
	}

	//Read
	public String getPost(String posterName, int postId) {
		//String postContent = executeUpdate("SELECT postContent FROM Posts WHERE Id = " + postId + "AND Name = " + posterName + ";"
		
		return ""/*postContent*/;
	}
	
	//Update
	public String updatePost(String posterName, int postId, String postEdit) {
		
		return "This will need to get the existing poost and edit it";
	}
	
	//Delete
	public String deletePost(String posterName, int postId) {
		return "This will need to take in a post by Id as a paramater and delete it";
	}
}
