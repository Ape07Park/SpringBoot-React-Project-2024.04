package com.example.reactProject.dao;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.reactProject.entity.User;

@Mapper
public interface UserDao {
	
	@Select("select * from users where uid=#{uid}")
	User getUserByUid(String uid);

	@Select("select * from users where isDeleted=0"
			+ " order by regDate desc limit #{count} offset #{offset}")
	List<User> getUserList(int count, int offset);
	
}