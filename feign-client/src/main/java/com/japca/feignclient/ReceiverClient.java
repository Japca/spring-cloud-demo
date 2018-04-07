package com.japca.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jakub krhovják on 4/7/18.
 */
@FeignClient("receiver-service")
public interface ReceiverClient {

	@RequestMapping("/receive")
	String receive();
}
