package com.brazil.brazilian_business_utilities_API;

import org.springframework.boot.SpringApplication;

public class TestBrazilianBusinessUtilitiesApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BrazilianBusinessUtilitiesApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
