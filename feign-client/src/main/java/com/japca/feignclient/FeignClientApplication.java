package com.japca.feignclient;

import com.japca.data.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping
	public String ok() {
		return "OK";
	}

	@GetMapping("call")
	public String callReceive() {
		return receiverClient.receive();
	}

	@RequestMapping(value = "callPost")
	public String callReceivePost() {
		return receiverClient.receive(new PostData("Hi post", 23));
	}
}
