package com.nilerbarcelos.controller;

import org.json.JSONObject;
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
public class OrderControllerTest {

	private static final String EDITED_ORDER = "{\"id\":1,\"customer\":{\"id\":4,\"name\":\"Imperador Palpatine\"},\"items\":[{\"id\":1,\"order\":1,\"product\":{\"id\":7,\"name\":\"DL-44 Heavy Blaster Pistol\",\"unitPrice\":1500.0,\"multiple\":10},\"quantity\":10,\"unitPrice\":1500.0}]}";
	private static final String SAVED_ORDER = "{\"id\":1,\"customer\":{\"id\":3,\"name\":\"Luke Skywalker\"},\"items\":[{\"id\":1,\"order\":1,\"product\":{\"id\":7,\"name\":\"DL-44 Heavy Blaster Pistol\",\"unitPrice\":1500.0,\"multiple\":10},\"quantity\":10,\"unitPrice\":1500.0}]}";
	private static final String ORDER_TO_SAVE = "{\"customer\":{\"id\":3,\"name\":\"Luke Skywalker\"},\"items\":[{\"product\":{\"id\":7,\"name\":\"DL-44 Heavy Blaster Pistol\",\"unitPrice\":1500,\"multiple\":10},\"unitPrice\":1500,\"multiple\":10,\"quantity\":10,\"profitability\":\"Rentabilidade Boa\"}]}";
	private static final String GREAT_PROFITABILITY_URL = "/order/profitability?itemPrice=501&productPrice=500";
	private static final String GOOD_PROFITABILITY_URL = "/order/profitability?itemPrice=490&productPrice=500";
	private static final String BAD_PROFITABILITY_URL = "/order/profitability?itemPrice=200&productPrice=500";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldCreateAndReadOrders() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/order")
			.content(ORDER_TO_SAVE)
			.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content().string(SAVED_ORDER));
		mockMvc.perform(MockMvcRequestBuilders.post("/order")
				.content(EDITED_ORDER)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string(EDITED_ORDER));
		mockMvc.perform(MockMvcRequestBuilders.get("/order/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(EDITED_ORDER));
    }	
	
	@Test
	public void shouldGetGreatProfitability() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(GREAT_PROFITABILITY_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(JSONObject.quote("Rentabilidade Ótima")));
	}
	
	@Test
	public void shouldGetGoodProfitability() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(GOOD_PROFITABILITY_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(JSONObject.quote("Rentabilidade Boa")));
	}
	
	@Test
	public void shouldGetBadProfitability() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(BAD_PROFITABILITY_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(JSONObject.quote("Rentabilidade Ruim")));
	}
}
