package com.tgl.mpos.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.jaxws.LocalJaxWsServiceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgl.mpos.dao.model.CodeItemDef;
import com.tgl.mpos.dao.model.UserEntity;
import com.tgl.mpos.dao.common.DAOException;
import com.tgl.mpos.dao.jdbc.UsersDao;
//import com.tgl.mpos.dao.mapper.CodeItemDefMapper;
import com.tgl.mpos.dao.mapper.UserMapper;
import com.tgl.mpos.dao.mapper.slave.User2Mapper;
import com.tgl.mpos.service.BookService;



@PropertySource("classpath:/props/${spring.profiles.active}/app.properties")
@RestController
public class HomeController {

	@Autowired
	BookService bookService;

	@Autowired
	private UserMapper userMapper;

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// @Autowired
	// private CodeItemDefMapper codeMapper;

	// @Autowired
	// private User2Mapper userMapper2;
	
	@Autowired
	private UsersDao daoUsers;

	@Autowired
	private Environment env;

	// @Value("${dao.jar.info}")
	private String msg;

	// @Value("${jar.info}")
	// private String jar_info;
	
	@GetMapping("/dao")
	public String dao() {
		
		UserEntity entity = daoUsers.getUser(1);
		return entity.getNickName();
		
	}

	@GetMapping("/home")
	public String index() {

		// return msg;

		System.out.println(msg);
		System.out.println(env.getProperty("service.jar.info"));
		System.out.println(env.getProperty("dao.jar.info"));
		
		logger.info("This is logger.info");
		logger.error("This is logger.error");
		
		System.out.println("This is System.out.println");

		return "Hello Amy! , env is " + env.getProperty("dao.jar.info");

	}

	// @GetMapping("/name")
	// public String name() {
	//
	// UserEntity user = userMapper.getByName("Leo");
	// System.out.println("user name is " + user.getUserName());
	// return user.getNickName();
	//
	// }
	//
	// @GetMapping("/code")
	// public String user(String code) {
	// if (code == null || code == "") {
	// code = "COUGH";
	// }
	// CodeItemDef codeObj = codeMapper.getByCode(code);
	// return codeObj.getItemDesc();
	// }
	//
	@GetMapping("/user")
	public String user() {
		UserEntity user = userMapper.getOne(Long.valueOf("2"));
		System.out.println("user name is " + user.getUserName());
		return user.getUserName();
	}
	//
	// @GetMapping("/user2")
	// public String user2() {
	// UserEntity user2 = userMapper2.getOne(Long.valueOf("2"));
	// System.out.println("user name is " + user2.getUserName());
	// return user2.getUserName();
	// }

}
