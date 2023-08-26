package com.SendLocationToNearestPerson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope //express an endpoint named "/refresh" to import the changes in properties with out restarting
@EnableDiscoveryClient
public class SendLocationToNearestPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendLocationToNearestPersonApplication.class, args);
	}

}
