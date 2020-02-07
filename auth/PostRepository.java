package com.BlankBlog.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Long>{
	
	User findByUsername(Sring username);

}
