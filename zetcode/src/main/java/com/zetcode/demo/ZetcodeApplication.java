package com.zetcode.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ZetcodeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ZetcodeApplication.class, args);
	}

}
