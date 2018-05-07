package com.japca.feignclient;

import com.japca.data.PostData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Jakub krhovják on 4/7/18.
 */
@FeignClient("receiver-service")
public interface ReceiverClient {

	@GetMapping("/receive")
	String receive();

	@PostMapping(value = "/receive")
	String receive(@RequestBody PostData postData);
}
