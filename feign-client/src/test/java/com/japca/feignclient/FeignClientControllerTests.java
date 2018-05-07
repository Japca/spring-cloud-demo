package com.japca.feignclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.japca.data.PostData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = FeignClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(ids = {"com.japca:receiver-service:+:stubs:8082"}, workOffline = true)
@AutoConfigureMockMvc
@DirtiesContext
public class FeignClientControllerTests {

	@Autowired
	private ReceiverClient receiverClient;

	@Autowired
	private MockMvc mvc;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void callClientDirectly() throws Exception {
		receiverClient.receive();
	}

	@Test
	public void callWithController() throws Exception {
		mvc.perform(get("/call")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("/receive-get")))
				.andExpect(status().isOk());

	}


	@Test
	public void callPostTest() throws Exception {
		mvc.perform(post("/callPost")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(new PostData("Test name",23))))
				.andExpect(content().string(containsString("/receive-post")))
				.andExpect(status().isOk());
	}


}
