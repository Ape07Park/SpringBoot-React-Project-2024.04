package com.example.reactProject.controller;

import java.net.URLEncoder; 
import java.util.ArrayList; 
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.reactProject.entity.User;
import com.example.reactProject.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONArray;

@RestController 	/* 화면을 rendering 하지 않고, 데이터를 바로 보내는 컨트롤러 (ResponseBody 느낌) 
따라서 일일이 ResponseBody 안해도 됨 */
@RequestMapping("/react")
@RequiredArgsConstructor
public class ReactController {
	private final UserService userService;
	
	@GetMapping("/data")
	public String data() {
		return "스프링부트에서 보낸 데이터";
	}
	
	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제임스");
		
		return jObj.toString();
	}
	
	@PostMapping("/form")
	public String form(String uid, String uname) {
		System.out.println("uid=" + uid + ", uname=" + uname);
		return "uid=" + uid + ", uname=" + uname;
	}
	
	@PostMapping("/multi")
	public String form(String uid, String uname, MultipartFile file) {
		String msg = "uid=" + uid + ", uname=" + uname + ", fname=" + file.getOriginalFilename();
		System.out.println(msg);
		return msg;
	}
	
	/*
	 * 1개만 불러오기
	 */
	@GetMapping("/oneUser")
	public String oneUser() {
		String uid = "admin";
		User user = userService.getUserByUid(uid);
		JSONObject jObj = new JSONObject();
		
		jObj.put("uid", user.getUid());
		jObj.put("pwd", user.getPwd());
		jObj.put("uname", user.getUname());
		jObj.put("email", user.getEmail());
		jObj.put("regDate", user.getRegDate().toString());
		jObj.put("isDeleted", user.getIsDeleted());
		jObj.put("profile", user.getProfile());
		jObj.put("github", user.getGithub());
		jObj.put("insta", user.getInsta());
		jObj.put("location", user.getLocation());
		
		System.out.println(jObj);
		
		return jObj.toString();
	}
	
	@GetMapping("/users")
	public String users() {
		List<User> list = userService.getUserList(1);
//		JSONObject jObj = new JSONObject();
		JSONArray jArr = new JSONArray();
		for (User user: list) {
			JSONObject jUser = new JSONObject();
			jUser.put("uid", user.getUid());
			jUser.put("pwd", user.getPwd());
			jUser.put("uname", user.getUname());
			jUser.put("email", user.getEmail());
			jUser.put("regDate", user.getRegDate().toString());
			jUser.put("isDeleted", user.getIsDeleted());
			jUser.put("profile", user.getProfile());
			jUser.put("github", user.getGithub());
			jUser.put("insta", user.getInsta());
			jUser.put("location", user.getLocation());
			jArr.add(jUser);
		}
		System.out.println(jArr);
		return jArr.toString();
	}
	
	
		
	/*
	 * 객체 리스트 불러와 프론트에서 toString 하기
	 */
	@GetMapping("/pickingOne")
	public String pickingOne() {
		String uid = "admin";
		User user = userService.getUserByUid(uid);
		JSONObject jObj = new JSONObject();
		
		jObj.put("uid", user.getUid());
		jObj.put("uname", user.getUname());
		jObj.put("email", user.getEmail());
		jObj.put("regDate", user.getRegDate());
		jObj.put("profile", user.getProfile());
		jObj.put("github", user.getGithub());
		jObj.put("insta", user.getInsta());
		jObj.put("location", user.getLocation());
		System.out.println(jObj.toString());
				
		return jObj.toString();
	}	
}
