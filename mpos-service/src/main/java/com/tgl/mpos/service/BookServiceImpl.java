package com.tgl.mpos.service;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	public String getBookList() {
		return "getBookList:" + new Data() {
		};
	}

}