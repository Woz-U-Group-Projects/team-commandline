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
import java.sql.Statement;
import java.sql.ResultSet;


@RestController
public class PostController {
	@Autowired
	private PostDao dao;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	//Create new post
	public String createPost(String postContent, String name, int date) {
		
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			stmt.execute("INSERT INTO Posts (name, content) VALUES (" + name + ", " + postContent + ");");
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return "New post created: " + postContent;
	}

	//Read posts
	public String getPost(String posterName, long postId) {
		String returnedPost;
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			returnedPost = stmt.executeQuery("SELECT postContent FROM Posts WHERE username = " + posterName + " AND id = " + postId +";").toString();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return returnedPost;
	}
	
	//Update existing posts
	public String updatePost(long postId, String postEdit) {
		Connection con;
		try {
			con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE Posts SET postContent = '" + postEdit + "' WHERE Id = " + postId + ";");
			
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return "Post Updated: " + postId + " now contains " + postEdit;
	}
	
	//Delete posts
	public String deletePost(String posterName, long postId) {
		Connection con;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			
			Statement stmt = con.createStatement();
			stmt.execute("DELETE * FROM Posts WHERE Id = " + postId + ";");
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return "Post " + postId + " deleted";
	}
}
