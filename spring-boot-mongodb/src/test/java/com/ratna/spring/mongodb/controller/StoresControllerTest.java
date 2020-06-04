package com.ratna.spring.mongodb.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratna.spring.mongodb.exceptions.NoInventoryDataException;
import com.ratna.spring.mongodb.model.Inventory;
import com.ratna.spring.mongodb.model.Staff;
import com.ratna.spring.mongodb.service.InventoryService;

@ExtendWith(SpringExtension.class)
@EnableWebMvc
@WebMvcTest(StoresController.class)
@AutoConfigureWebMvc
class StoresControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	InventoryService mockIn;
	List<Inventory> inventoryMockList = new ArrayList<Inventory>();
	List<Staff> staffMockList = new ArrayList<Staff>();

	@BeforeEach
	public void inventorySetUp() {
		Inventory inventory = new Inventory();
		inventory.setFilmId(1);
		inventory.setFilmId(1);
		inventory.setTitle("Lion King");
		inventoryMockList.add(inventory);
	}

	@BeforeEach
	public void staffSetUp() {
		Staff staff = new Staff();
		staff.setFname("Ratna");
		staff.setStaffId(1);
		staff.setLname("Srinivas");
		staff.setPhone(8499899121l);
		staff.setAddress("hyd");
		staff.setCountry("India");
		staff.setCity("hyd");
		staffMockList.add(staff);
	}

	@Test
	void testGetAllInventories() throws Exception {
		when(mockIn.getAllInventories()).thenReturn(inventoryMockList);
		String contentAsString = mockMvc
				.perform(get("/getAllInventories").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Inventory[] value = objectMapper.readValue(contentAsString, Inventory[].class);
		assertNotNull(value);
		assertEquals(1, value.length);
	}

	@Test
	void testGetAllStaff() throws Exception {
		when(mockIn.getAllStaff()).thenReturn(staffMockList);
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllStaff").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].address").value("hyd")).andExpect(jsonPath("$.[0].fname").value("Ratna"));
	}

	@Test
	void testGetAllInventoriesException() throws Exception {
		when(mockIn.getAllInventories()).thenThrow(NoInventoryDataException.class);
		mockMvc.perform(
				get("/getAllInventories").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andReturn().getResponse();

	}

}
