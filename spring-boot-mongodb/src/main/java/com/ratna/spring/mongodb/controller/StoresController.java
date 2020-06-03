package com.ratna.spring.mongodb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ratna.spring.mongodb.exceptions.NoInventoryDataException;
import com.ratna.spring.mongodb.exceptions.NoStaffDataException;
import com.ratna.spring.mongodb.model.Inventory;
import com.ratna.spring.mongodb.model.Staff;
import com.ratna.spring.mongodb.service.InventoryService;

@RestController
public class StoresController {

	@Autowired
	public InventoryService inventoryService;

	@GetMapping(value = "/getAllInventories", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Inventory> getAllInventories() {
		try {
			return inventoryService.getAllInventories();
		} catch (NoInventoryDataException e) {
			throw new NoInventoryDataException("No Inventories available");
		}
	}

	@GetMapping(value ="/getAllStaff", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Staff> getAllStaff() {
		try {
			return inventoryService.getAllStaff();
		} catch (NoStaffDataException e) {
			throw new NoStaffDataException("No Staff available");
		}
	}
}
