package com.japca.receiverservice.controller;

import com.japca.data.PostData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@RestController
public class ReceiverController {

	@GetMapping(value = "/restCall")
	public String restCall() {
		return"/restCall-get";
	}

	@GetMapping(value = "/receive")
	public String receiveGet() {
		return "/receivePost-get";
	}

	@PostMapping(value = "/receive")
	public String receivePost(@RequestBody PostData postData) {
		return  "/receivePost-post";
	}
}
