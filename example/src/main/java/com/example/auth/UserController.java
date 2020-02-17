package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.example.auth.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	  private MySQLUserDetailsService userService;
	  @PostMapping("/register")
	  public void register(@RequestBody User newUser) {
	    userService.Save(newUser);
	  }

	  @Value("${spring.datasource.url}")
	  private String url;

	  @Value("${spring.datasource.username}")
	  private String username;

	  @Value("${spring.datasource.password}")
	  private String password;

	  //Create

	  public String createUser(String userName, String userPassword) {
		  Connection con;

		  try {
			  con = DriverManager.getConnection(url, username, password);
			  Statement stmt = con.createStatement();

			  stmt.execute("INSERT INTO Users (username, password) VALUES (" + userName +", " + userPassword + ");");
			  con.close();
		  } catch(SQLException e) {
			  e.printStackTrace();
		  }
		  return "User created: " + userName;

	  }

	  //Read

	  //not really sure what data we should get for user

	  //Update user password

	  public String updatePassword(String userName, String newPassword) {
		  Connection con;

		  try {
			  con = DriverManager.getConnection(url, username, password);
			  Statement stmt = con.createStatement();

			  stmt.execute("UPDATE Users SET password = " + newPassword + " WHERE username = " + userName + ";");
		  } catch(SQLException e) {
			  e.printStackTrace();
		  }

		  return userName + "'s password has been changed.";
	  }

	  //Delete user

	  public String deleteUser(String userName) {
		  Connection con;

		  try {
			  con = DriverManager.getConnection(url, username, password);
			  Statement stmt = con.createStatement();

			  stmt.execute("DELETE * FROM Users WHERE username = " + userName + ";");
		  } catch(SQLException e) {
			  e.printStackTrace();
		  }
	  }
}
