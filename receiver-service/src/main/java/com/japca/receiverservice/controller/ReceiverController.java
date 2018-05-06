package com.japca.receiverservice.controller;

import com.japca.data.PostData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@RestController
public class ReceiverController {

	public static final String REST_CALL = "/restCall";

	@Autowired
	private DiscoveryClient client;

	@GetMapping(REST_CALL)
	public String restCall() {
		throw new RuntimeException();
//		return "receiver-service";
	}

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
