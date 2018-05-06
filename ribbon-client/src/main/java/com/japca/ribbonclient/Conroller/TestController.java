package com.japca.ribbonclient.Conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@RestController
public class TestController {

	@GetMapping("/")
	public String ok() {
		return "OK";
	}
}
