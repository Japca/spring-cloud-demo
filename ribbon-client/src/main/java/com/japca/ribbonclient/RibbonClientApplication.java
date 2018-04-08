package com.japca.ribbonclient;

import com.japca.data.PostData;
import com.japca.ribbonclient.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
@RestController
//@RibbonClient(name = "receiver-service", configuration = HelloServiceConfiguration.class)
public class RibbonClientApplication {

	@Autowired
	private RecordService recordService;


	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}

	@RequestMapping("call")
	public String callReceiver() {
		return restTemplate().getForObject("http://receiver-service/receive", String.class);
	}

	@RequestMapping("callPost")
	public String callReceiverPost() {
		return restTemplate()
				.postForEntity("http://receiver-service/receive", new PostData("RestTemplate", 23), String.class)
				.getBody();

	}


//	public class HelloServiceConfiguration {
//		@Autowired
//		IClientConfig ribbonClientConfig;
//
//		@Bean
//		public IPing ribbonPing(IClientConfig config) {
//			return new PingUrl();
//		}
//		@Bean
//		public IRule ribbonRule(IClientConfig config) {
//			return new AvailabilityFilteringRule();
//		}
//	}
}
