package com.japca.feignclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FeignClientApplication.class},
		webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWireMock(port = 8082)
public class SimpleWireMockIntegrationTest extends IntegrationTest {



	@Test
	public void simpleRestCallTest() throws Exception {
		stubFor(get(urlEqualTo("/restCall"))
				.willReturn(aResponse()
						.withHeader("Content-Type", MediaType.APPLICATION_JSON.toString())
						.withBody("receiver-service")));

		mvc.perform(MockMvcRequestBuilders.get("/restCall")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("receiver-service")))
				.andExpect(status().isOk());

	}
}
