package com.pit.msaggregatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableFeignClients
@SpringBootApplication
public class MsaggregatorserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaggregatorserviceApplication.class, args);
	}

}
