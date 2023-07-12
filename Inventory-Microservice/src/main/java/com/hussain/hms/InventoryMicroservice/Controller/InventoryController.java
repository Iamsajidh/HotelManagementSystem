package com.hussain.hms.InventoryMicroservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.InventoryMicroservice.Models.Inventory;
import com.hussain.hms.InventoryMicroservice.Service.Inventoryservice;
import com.hussain.hms.InventoryMicroservice.Exception.InventoryNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private Inventoryservice inventoryService;

    @PostMapping("/add")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    @GetMapping("/get/{id}")
    public Inventory getInventory(@PathVariable long id) {
        Optional<Inventory> inventory = inventoryService.getInventory(id);
        if (inventory.isPresent()) {
            return inventory.get();
        }
        throw new InventoryNotFoundException("Inventory not found with ID: " + id);
    }

    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PutMapping("/update")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        Optional<Inventory> existingInventory = inventoryService.getInventory(inventory.getInventoryId());
        if (existingInventory.isPresent()) {
            return inventoryService.updateInventory(inventory);
        }
        throw new InventoryNotFoundException("Inventory not found with ID: " + inventory.getInventoryId());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInventory(@PathVariable long id) {
        Optional<Inventory> existingInventory = inventoryService.getInventory(id);
        if (existingInventory.isPresent()) {
            return inventoryService.deleteInventory(id);
        }
        throw new InventoryNotFoundException("Inventory not found with ID: " + id);
    }
}
