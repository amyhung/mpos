package com.tgl.mpos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgl.mpos.service.BookService;

@RestController
public class HomeController {

	@Autowired
	BookService bookService;

	@GetMapping("/home")
	public String index() {
		return "Hello Amy! " + bookService.getBookList();
	}

}
