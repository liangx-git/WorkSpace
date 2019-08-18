package com.liangx.practice.booksystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liangx.practice.booksystem.entity.User;
import com.liangx.practice.booksystem.mapper.UserMapper;


@RestController("/booksystem")
public class Controller {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/user/{id}")
	public User getAllUsers(@PathVariable("id") String  userId) {

		return userMapper.selectByPrimaryKey(userId);
	}

}
