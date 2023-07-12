package com.hussain.hms.InventoryMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hussain.hms.InventoryMicroservice.Models.Inventory;
import com.hussain.hms.InventoryMicroservice.Repository.InventoryRepo;
import com.hussain.hms.InventoryMicroservice.Exception.InventoryNotFoundException;

@Service
public class InventoryserviceImpl implements Inventoryservice {
	
    private static final Logger logger = LoggerFactory.getLogger(InventoryserviceImpl.class);

    @Autowired
    InventoryRepo inventoryRepo;

    @Override
    public Inventory addInventory(Inventory inv) {
        logger.info("Adding inventory: {}", inv);
        return inventoryRepo.insert(inv);
    }

    @Override
    public List<Inventory> getAllInventory() {
        logger.info("Retrieving all inventory");
        return inventoryRepo.findAll();
    }

    @Override
    public Optional<Inventory> getInventory(long id) {
        logger.info("Retrieving inventory with ID: {}", id);
        Optional<Inventory> inventory = inventoryRepo.findById(id);
        if (inventory.isEmpty()) {
            throw new InventoryNotFoundException("Inventory not found with ID: " + id);
        }
        return inventory;
    }

    @Override
    public Inventory updateInventory(Inventory inv) {
        logger.info("Updating inventory: {}", inv);
        return inventoryRepo.save(inv);
    }

    @Override
    public String deleteInventory(long id) {
        logger.info("Deleting inventory with ID: {}", id);
        if (!inventoryRepo.existsById(id)) {
            throw new InventoryNotFoundException("Inventory not found with ID: " + id);
        }
        inventoryRepo.deleteById(id);
        return "Deleted inventory with ID: " + id;
    }
}
