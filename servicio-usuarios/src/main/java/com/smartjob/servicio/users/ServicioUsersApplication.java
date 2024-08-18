package com.smartjob.servicio.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioUsersApplication.class, args);
	}

}
