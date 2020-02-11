package com.example.post;


//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.*;

import com.example.post.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@RestController
public class PostController implements PostDao<Post> {

	@Autowired
	private PostDao dao;
	
	//Create
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
}
