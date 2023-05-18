package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Recipe;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("from User where username=?1")
	public List<User> findByUserName(String name);
	
	@Query("from User where email=?1 and password=?2")
	public User findUserByEmailAndPassword(String email, String Password);
	
	@Query("FROM User WHERE email = ?1")
	public User findUserByEmail(String email);
	
//	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
	
}
