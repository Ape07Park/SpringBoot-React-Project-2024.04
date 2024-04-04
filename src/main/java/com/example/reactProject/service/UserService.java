package com.example.reactProject.service;

import java.util.List;

import com.example.reactProject.entity.User;

public interface UserService {
	public static final int COUNT_PER_PAGE = 10;

	User getUserByUid(String uid);
	
	List<User> getUserList(int page);
	
	int getUserCount();
	
	void registerUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(String uid);
	
	int login(String uid, String pwd);
	
}