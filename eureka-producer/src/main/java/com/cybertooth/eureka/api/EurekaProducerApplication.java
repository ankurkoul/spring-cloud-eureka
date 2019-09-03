package com.cybertooth.eureka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class EurekaProducerApplication {
	 
	@Autowired
    GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducerApplication.class, args);
	}

	@RequestMapping("/get-greeting")
    public String greeting(Model model) {
      String s= greetingClient.greeting();
      System.out.println("url data================>	:"+s);
      return s;
    }
}
