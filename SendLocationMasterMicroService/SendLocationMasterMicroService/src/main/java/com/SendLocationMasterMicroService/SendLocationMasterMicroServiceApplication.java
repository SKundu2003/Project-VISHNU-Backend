package com.SendLocationMasterMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RefreshScope //express an endpoint named "/refresh" to import the changes in properties with out restarting
@EnableDiscoveryClient
@EnableFeignClients  //needed to use feignclient

public class SendLocationMasterMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendLocationMasterMicroServiceApplication.class, args);
	}

}
