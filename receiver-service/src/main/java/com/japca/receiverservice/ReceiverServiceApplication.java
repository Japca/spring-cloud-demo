package com.japca.receiverservice;

import com.japca.data.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ReceiverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiverServiceApplication.class, args);
	}

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public String receive() {
		ServiceInstance localInstance = client.getLocalServiceInstance();
		return "Receive endpoint: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}

	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	public String receive(@RequestBody PostData postData) {
		return  receive() + postData;
	}


}
