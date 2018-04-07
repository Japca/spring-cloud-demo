package com.japca.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignClientApplication {

	@Autowired
	private ReceiverClient receiverClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}


	@RequestMapping("call")
	public String callReceive() {
		return receiverClient.receive();
	}


}
