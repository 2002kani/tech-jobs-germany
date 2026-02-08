package com.studitech.aggregationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AggregationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregationserviceApplication.class, args);
	}

}
