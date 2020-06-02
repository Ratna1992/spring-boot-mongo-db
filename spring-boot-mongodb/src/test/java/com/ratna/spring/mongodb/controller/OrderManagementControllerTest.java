package com.ratna.spring.mongodb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratna.spring.mongodb.model.Address;
import com.ratna.spring.mongodb.model.Product;
import com.ratna.spring.mongodb.model.User;

@WebMvcTest(OrderManagementController.class)
@AutoConfigureMockMvc
class OrderManagementControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private OrderManagementController orderManagementController;

	ObjectMapper mapper = new ObjectMapper();
	User mockUser = null;

	@BeforeEach
	void getMockData() {
		mockUser = new User();
		mockUser.setId(4);
		mockUser.setGender("Male");
		mockUser.setName("ABC");
		Address address = new Address();
		address.setCity("Hyd");
		address.setPinCode(500081);
		address.setState("Telangana");
		mockUser.setAddress(address);
		List<Product> products = new ArrayList<>();
		Product p1 = new Product();
		p1.setName("Cooler");
		p1.setPrice(13000d);
		p1.setQuantity(1);
		products.add(p1);
		mockUser.setProducts(products);
	}

	@Test
	void testPlaceOrder() throws Exception {
		mvc.perform(post("/placeorder").content(mapper.writeValueAsString(mockUser))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	void testFetchorder() throws Exception {
		mvc.perform(get("/fetchorder").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
