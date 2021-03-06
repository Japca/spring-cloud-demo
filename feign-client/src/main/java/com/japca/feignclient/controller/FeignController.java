package com.japca.feignclient.controller;

import com.japca.data.PostData;
import com.japca.feignclient.ReceiverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */
@RestController
public class FeignController {

	@Autowired
	private ReceiverClient receiverClient;

	@GetMapping("call")
	public String callReceive() {
		return receiverClient.receive();
	}

	@PostMapping("callPost")
	public String callReceivePost(@RequestBody PostData postData) {
		return receiverClient.receive(postData);
	}

}
