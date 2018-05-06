package com.japca.receiverservice.controller;

import com.japca.data.PostData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@RestController
public class ReceiverController {

	@RequestMapping(value = "/restCal", method = RequestMethod.GET)
	public String restCall() {
		return "/restCall-get";
	}

	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public String receive() {
		return "/receive-get";
	}

	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	public String receive(@RequestBody PostData postData) {
		return  "/receive-post";
	}
}
