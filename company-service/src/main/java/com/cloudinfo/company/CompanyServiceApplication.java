package com.cloudinfo.company;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title = "Jhunter microservice project - Company Service Rest API Documentation",
				description="Jhunter microservice project - a job-seeking platform",
				version = "v1.0.0",
				contact = @Contact(
						name = "Trần Ngọc Tiến - Patrick",
						email="patricktrandev@gmail.com",
						url = "www.linkedin.com/in/patricktrandev"
				)
		)
)
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

}
