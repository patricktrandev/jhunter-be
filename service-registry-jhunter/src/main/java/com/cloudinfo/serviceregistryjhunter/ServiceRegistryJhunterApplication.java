package com.cloudinfo.serviceregistryjhunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryJhunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryJhunterApplication.class, args);
	}

}
