package com.japca.feignclient;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Jakub Krhovják on 5/6/18.
 */
public abstract class IntegrationTest {

	protected MockMvc mvc;

	@Autowired
	private WebApplicationContext context;


	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}
}
