package com.hussain.hms.InventoryMicroservice.Service;

import java.util.List;
import java.util.Optional;

import com.hussain.hms.InventoryMicroservice.Models.Inventory;

public interface Inventoryservice {

	Inventory addInventory(Inventory inv);

	Optional<Inventory> getInventory(long parseLong);

	Inventory updateInventory(Inventory inv);

	String deleteInventory(long parseLong);

	List<Inventory> getAllInventory();

}