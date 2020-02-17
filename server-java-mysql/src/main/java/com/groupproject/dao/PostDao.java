package com.groupproject.dao;
import org.springframework.data.repository.CrudRepository;
import com.example.groupproject.models.Post;

public interface PostDao extends CrudRepository<Post, Integer>{

}
