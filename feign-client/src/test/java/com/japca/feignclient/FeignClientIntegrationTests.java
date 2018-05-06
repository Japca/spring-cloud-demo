package com.japca.feignclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignClientIntegrationTests extends IntegrationTest {


	@Test
	public void callTest() throws Exception {
		stubFor(get(urlEqualTo("/call"))
				.willReturn(aResponse()
						.withHeader("Content-Type", MediaType.APPLICATION_JSON.toString())
						.withBody("receiver-service")));

		mvc.perform(MockMvcRequestBuilders.get("/call")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("receiver-service")))
				.andExpect(status().isOk());
	}

	@Test
	public void callPostTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/callPost")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("receiver-service")))
				.andExpect(status().isOk());
	}


}
