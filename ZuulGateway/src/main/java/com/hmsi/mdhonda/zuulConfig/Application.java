package com.hmsi.mdhonda.zuulConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 @Bean
	  public SimplePreFilter simplePreFilter() {
	     return new SimplePreFilter();
	  }

	 @Bean
	  public SimplePostFilter simplePostFilter() {
	     return new SimplePostFilter();
	  }

}
