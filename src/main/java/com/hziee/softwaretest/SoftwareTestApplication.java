package com.hziee.softwaretest;

import com.hziee.softwaretest.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SoftwareTestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftwareTestApplication.class, args);
		SpringUtil.setApplicationContext(context);
	}
}
