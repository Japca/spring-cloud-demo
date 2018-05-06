package com.japca.feignclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@TestPropertySource(properties = {
//		"feign.client.ribbon.eureka.enabled=false",
//		"feign.client.ribbon.listOfServers=localhost:${local.server.port}"
//})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FeignClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(ids = {"com.japca:receiver-service:+:stubs:8082"}, workOffline = true)
@AutoConfigureMockMvc
public class FeignClientControllerTests {

	@Autowired
	private ReceiverClient receiverClient;

	@Autowired
	private MockMvc mvc;


	@Test
	public void callClientDirectly() throws Exception {
		receiverClient.receive();
	}

	@Test
	public void callWithController() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/call")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("receive-service")))
				.andExpect(status().isOk());

	}

	//
//		mvc.perform(MockMvcRequestBuilders.get("/call")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().string(containsString("receiver-service")))
//				.andExpect(status().isOk());

//	@Test
//	public void callPostTest() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/callPost")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().string(containsString("receiver-service")))
//				.andExpect(status().isOk());
//	}


}
