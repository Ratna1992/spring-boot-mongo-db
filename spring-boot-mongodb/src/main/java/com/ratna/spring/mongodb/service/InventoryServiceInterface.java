package com.ratna.spring.mongodb.service;

import java.util.List;

import com.ratna.spring.mongodb.model.Inventory;
import com.ratna.spring.mongodb.model.Staff;

public interface InventoryServiceInterface {

	List<Inventory> getAllInventories();

	List<Staff> getAllStaff();
}
