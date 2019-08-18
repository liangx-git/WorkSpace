package com.liangx.practice.booksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.liangx.practice.booksystem.mapper"})
public class BooksystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksystemApplication.class, args);
	}

}
