package com.DiscoveryServerForProjectVISHNU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer	// This annotation is used to enable the Eureka Server
@SpringBootApplication
@RefreshScope // This annotation is used to refresh the scope of the application
public class DiscoveryServerForProjectVishnuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerForProjectVishnuApplication.class, args);
	}

}
