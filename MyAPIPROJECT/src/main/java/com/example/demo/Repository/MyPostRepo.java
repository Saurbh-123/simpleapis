package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Catogry;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;

public interface MyPostRepo extends JpaRepository<Post, Integer>{
	
     List<Post> findByUser(User user);
     List<Post> findByCatogry(Catogry catogry); 
    
}
