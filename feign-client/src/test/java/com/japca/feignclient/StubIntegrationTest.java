package com.japca.feignclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(ids = {"com.japca:receiver-service:+:stubs:8082"}, workOffline = true)
@DirtiesContext
@Slf4j
public class StubIntegrationTest {

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void simpleRestCallTest() throws Exception {
//		stubFor(get(urlEqualTo("/restCall"))
//				.willReturn(aResponse()
//						.withHeader("Content-Type", MediaType.APPLICATION_JSON.toString())
//						.withBody("receiver-service")));

//		mvc.perform(MockMvcRequestBuilders.get("/restCall")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().string(containsString("receiver-service")))
//				.andExpect(status().isOk());

		String body = restTemplate.getForEntity("http://localhost:8082/restCall", String.class).getBody();
		log.info("body: {}", body);

	}
}
