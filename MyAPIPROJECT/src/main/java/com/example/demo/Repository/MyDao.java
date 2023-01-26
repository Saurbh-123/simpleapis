package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface MyDao extends JpaRepository<User, Integer>{
	
	@Query(name = "SELECT *  From FuckYou where name= name1",nativeQuery = true)
	User findByname(@Param(value = "name1") String name);

}
