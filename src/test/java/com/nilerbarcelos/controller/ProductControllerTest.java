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
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static final String EXPECTED_JSON = "[{\"id\":1,\"name\":\"Millenium Falcon\",\"unitPrice\":550000.0,\"multiple\":0},{\"id\":2,\"name\":\"X-Wing\",\"unitPrice\":60000.0,\"multiple\":2},{\"id\":3,\"name\":\"Super Star Destroyer\",\"unitPrice\":4570000.0,\"multiple\":0},{\"id\":4,\"name\":\"TIE Fighter\",\"unitPrice\":75000.0,\"multiple\":2},{\"id\":5,\"name\":\"Lightsaber\",\"unitPrice\":6000.0,\"multiple\":5},{\"id\":6,\"name\":\"DLT-19 Heavy Blaster Rifle\",\"unitPrice\":5800.0,\"multiple\":0},{\"id\":7,\"name\":\"DL-44 Heavy Blaster Pistol\",\"unitPrice\":1500.0,\"multiple\":10}]";

	@Test
	public void shouldGetProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(EXPECTED_JSON));
	}

}
