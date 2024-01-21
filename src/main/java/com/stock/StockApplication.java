package com.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.stock.repository")
@EntityScan(basePackages = "com.stock.entity")
@ComponentScan(basePackages = "com.stock")
public class StockApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}
