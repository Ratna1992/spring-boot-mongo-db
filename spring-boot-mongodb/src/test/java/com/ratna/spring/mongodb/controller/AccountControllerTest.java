package com.ratna.spring.mongodb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ratna.spring.mongodb.service.AccountHolderService;
import com.ratna.spring.mongodb.service.CsvProcessingService;

@ExtendWith(SpringExtension.class)
@EnableWebMvc
@WebMvcTest(AccountController.class)
@AutoConfigureWebMvc
class AccountControllerTest {

	@MockBean
	CsvProcessingService csvProcessingService;
	@MockBean
	AccountHolderService accountHolderService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testLoadData() throws Exception {
		mockMvc.perform(get("/loadData")).andExpect(status().isOk());
	}

	@Test
	void testGetAccountHolders() {
	}

	@Test
	void testGetRegionInformation() {
	}

	@Test
	void testGetAllAccounts() {
	}

	@Test
	void testGetAccountByIdInteger() {
	}

	@Test
	void testUpdateAccountHolderName() {
	}

	@Test
	void testGetAccountByIdString() {
	}

}
