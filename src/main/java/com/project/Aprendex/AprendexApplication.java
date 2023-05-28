package com.project.Aprendex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AprendexApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprendexApplication.class, args);
	}

}
