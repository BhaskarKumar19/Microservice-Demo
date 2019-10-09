package com.hmsi.mdhonda.authService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The service is responsible to validate user name and password for a given user and exchange it with jwt.
 * 
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
