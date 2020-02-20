package com.example.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.auth.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	  private MySQLUserDetailsService userService;
	  @PostMapping("/register")
	  public void register(@RequestBody final User newUser) {
		userService.Save(newUser);
	}

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	// Create

	public String createUser(final String userName, final String userPassword) {
		Connection con;

		try {
			con = DriverManager.getConnection(url, username, password);
			final Statement stmt = con.createStatement();

			stmt.execute("INSERT INTO Users (username, password) VALUES (" + userName + ", " + userPassword + ");");
			con.close();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return "User created: " + userName;

	}

	// Read

	// not really sure what data we should get for user

	// Update user password

	public String updatePassword(final String userName, final String newPassword) {
		Connection con;

		try {
			con = DriverManager.getConnection(url, username, password);
			final Statement stmt = con.createStatement();

			stmt.execute("UPDATE Users SET password = " + newPassword + " WHERE username = " + userName + ";");
		} catch (final SQLException e) {
			e.printStackTrace();
		}

		return userName + "'s password has been changed.";
	}

	// Delete user

	public String deleteUser(final String userName) {
		Connection con;

		try {
			con = DriverManager.getConnection(url, username, password);
			final Statement stmt = con.createStatement();

			stmt.execute("DELETE * FROM Users WHERE username = " + userName + ";");
		} catch (final SQLException e) {
			  e.printStackTrace();
		  }
		return userName;
	  }
}
