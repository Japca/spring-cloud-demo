package com.japca.ribbonclient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecordControllerIT {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	public void integrationTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/records"))
				.andExpect(status().isOk());

	}

	@Test
	public void saveIntegrationTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/save"))
				.andExpect(status().isOk())
     		    .andExpect(content() .string(containsString("new Record")))
				.andExpect(jsonPath("$.name", is("new Record")));
	}
}
