package com.tgl.mpos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tgl.mpos")
public class MposApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MposApiApplication.class, args);
	}

}
