package com.ratna.spring.mongodb.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratna.spring.mongodb.exceptions.NoInventoryDataException;
import com.ratna.spring.mongodb.model.Inventory;
import com.ratna.spring.mongodb.model.Staff;

@Service
public class InventoryService implements InventoryServiceInterface {

	@Autowired
	StoresRepository storesRepository;

	@Override
	public List<Inventory> getAllInventories() throws NoInventoryDataException {
		return storesRepository.findAll().stream().flatMap(obj -> obj.getInventory().stream())
				.collect(Collectors.toList());
	}

	@Override
	public List<Staff> getAllStaff() throws NoInventoryDataException {
		return storesRepository.findAll().stream().flatMap(obj -> obj.getStaff().stream()).collect(Collectors.toList());
	}

}
