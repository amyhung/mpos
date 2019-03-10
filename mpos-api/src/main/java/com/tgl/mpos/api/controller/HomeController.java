package com.tgl.mpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgl.mpos.dao.entities.UserEntity;
import com.tgl.mpos.dao.mapper.master.UserMapper;
import com.tgl.mpos.dao.mapper.slave.User2Mapper;
import com.tgl.mpos.service.BookService;

@PropertySource("classpath:/props/${spring.profiles.active}/app.properties")
@RestController
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private User2Mapper userMapper2;

	@Autowired
	private Environment env;

	@Value("${env.info}")
	private String msg;

	// @Value("${jar.info}")
	// private String jar_info;

	@GetMapping("/home")
	public String index() {

		// return msg;

		System.out.println(msg);
		System.out.println(env.getProperty("service.jar.info"));
		System.out.println(env.getProperty("dao.jar.info"));

		return "Hello Amy! , env is " + env.getProperty("app.env.info");

	}

	@GetMapping("/user")
	public String user() {
		UserEntity user = userMapper.getOne(Long.valueOf("2"));
		System.out.println("user name is " + user.getUserName());
		return user.getUserName();
	}

	@GetMapping("/user2")
	public String user2() {
		UserEntity user2 = userMapper2.getOne(Long.valueOf("2"));
		System.out.println("user name is " + user2.getUserName());
		return user2.getUserName();
	}

}
