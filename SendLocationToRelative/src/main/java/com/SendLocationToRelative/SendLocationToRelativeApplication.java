package com.SendLocationToRelative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope //express an endpoint named "/refresh" to import the changes in properties with out restarting
@EnableDiscoveryClient
public class SendLocationToRelativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendLocationToRelativeApplication.class, args);
	}

}
