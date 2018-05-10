package com.japca.receiverservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by Jakub Krhovják on 5/8/18.
 */

@RestController
public class ReactiveController {

	@GetMapping("data")
	public Flux<String> data() {
		return Flux.just("Hello", "second", "string");
	}

}
