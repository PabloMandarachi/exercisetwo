package com.exercisetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExercisetwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisetwoApplication.class, args);
	}

}
