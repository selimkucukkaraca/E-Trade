package com.example.etrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ETradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ETradeApplication.class, args);
	}

}