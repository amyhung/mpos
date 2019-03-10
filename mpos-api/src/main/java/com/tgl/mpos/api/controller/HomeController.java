package com.tgl.mpos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgl.mpos.dao.entities.UserEntity;
import com.tgl.mpos.dao.mapper.UserMapper;
import com.tgl.mpos.service.BookService;

@PropertySource("classpath:/props/${spring.profiles.active}/app.properties")
@RestController
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private Environment env;

	@Value("${env.info}")
	private String msg;

	// @Value("${jar.info}")
	// private String jar_info;

	@GetMapping("/home")
	public String index() {

		// return msg;

		UserEntity user = userMapper.getOne(Long.valueOf("2"));

		System.out.println(msg);
		System.out.println(env.getProperty("service.jar.info"));
		System.out.println(env.getProperty("dao.jar.info"));
		
		System.out.println("user name is " + user.getUserName());
		
		return "Hello Amy! " + user.getUserName() + ", env is " + env.getProperty("app.env.info");

	}

}
