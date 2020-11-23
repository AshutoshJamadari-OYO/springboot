package com.example.demoCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class }*/)
public class DemoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}
}
