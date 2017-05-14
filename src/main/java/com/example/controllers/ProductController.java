package com.example.controllers;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.UserInfo;
import com.example.service.UserService;

@RestController
public class ProductController {
	
	@Autowired
	private UserService userSer;
		
	@RequestMapping(value="/index/{id}", method=RequestMethod.GET)
	public String index(@PathVariable("id") int id) {
		return "get:"+id;
	}
	
	@PostMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/users")
	public List<UserInfo> users() {
		List<UserInfo> users = userSer.query();
		return users;
	}

}
