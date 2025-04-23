package com.cloudinfo.jhunterconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class JhunterConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(JhunterConfigApplication.class, args);
	}

}
