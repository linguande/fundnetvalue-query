package com.lingd.fundnetvaluequery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FundnetvalueQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundnetvalueQueryApplication.class, args);
	}
}
