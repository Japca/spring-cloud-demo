package com.japca.feignclient.controller;

import com.japca.data.PostData;
import com.japca.feignclient.ReceiverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */
@RestController
public class CallController {

	@Autowired
	private ReceiverClient receiverClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("call")
	public String callReceive() {
		return receiverClient.receive();
	}

	@GetMapping(value = "callPost")
	public String callReceivePost() {
		return receiverClient.receive(new PostData("Hi post", 23));
	}

	@GetMapping(value = "restCall")
	public String restCall() {
		return restTemplate.getForEntity("http://localhost:8082/restCall", String.class).getBody();
	}
}
