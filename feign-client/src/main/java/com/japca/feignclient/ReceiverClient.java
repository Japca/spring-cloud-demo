package com.japca.feignclient;

import com.japca.data.PostData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jakub krhovják on 4/7/18.
 */
@FeignClient("receiver-service")
public interface ReceiverClient {

	@RequestMapping("/receive")
	String receive();

	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	String receive(@RequestBody PostData postData);
}
