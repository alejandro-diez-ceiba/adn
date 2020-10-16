package com.ceiba.adn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.ceiba.adn")
public class AdnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdnApplication.class, args);
	}

}
