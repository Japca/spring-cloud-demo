package com.japca.feignclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
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

/**
 * Created by Jakub Krhovják on 5/6/18.
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(ids = {"com.japca:receiver-service:+:stubs:8082"}, workOffline = true)
public class ContractCallControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void simpleRestCallTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/restCall")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(containsString("receiver-service")))
				.andExpect(status().isOk());
	}
}
