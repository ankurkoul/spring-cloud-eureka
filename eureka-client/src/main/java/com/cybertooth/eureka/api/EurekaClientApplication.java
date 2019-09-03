package com.cybertooth.eureka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EurekaClientApplication {
	@Autowired
	private EurekaClient client;
	
	@Value("${spring.application.name}")
    private String appName;
 

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@GetMapping("/greeting")
    public String greeting() {
        return String.format("Hello from '%s'!", client.getApplication(appName).getName());
    }

}
