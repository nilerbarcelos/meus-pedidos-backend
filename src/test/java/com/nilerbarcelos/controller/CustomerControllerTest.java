package com.nilerbarcelos.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static final String EXPECTED_JSON = "[{\"id\":1,\"name\":\"Darth Vader\"},{\"id\":2,\"name\":\"Obi-Wan Kenobi\"},{\"id\":3,\"name\":\"Luke Skywalker\"},{\"id\":4,\"name\":\"Imperador Palpatine\"},{\"id\":5,\"name\":\"Han Solo\"}]";

	@Test
	public void shouldGetCustomers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customer")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(EXPECTED_JSON));
	}
}
