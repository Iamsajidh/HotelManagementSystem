package com.hussain.hms.InventoryMicroservice;

import com.hussain.hms.InventoryMicroservice.Models.Inventory;

import com.hussain.hms.InventoryMicroservice.Repository.InventoryRepo;
import com.hussain.hms.InventoryMicroservice.Service.Inventoryservice;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class InventoryMicroserviceApplicationTests {

    @Mock
    private InventoryRepo inventoryRepo;

    @InjectMocks
    private Inventoryservice inventoryService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllInventory() {
        // Mock data
        List<Inventory> inventoryList = Arrays.asList(
                new Inventory(1L, "Inventory 1", 10L, "Type 1"),
                new Inventory(2L, "Inventory 2", 5L, "Type 2")
        );
        when(inventoryRepo.findAll()).thenReturn(inventoryList);

        // Call the service method
        List<Inventory> result = inventoryService.getAllInventory();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Inventory 1", result.get(0).getInventoryName());
        assertEquals(10L, result.get(0).getInventoryStock());
        assertEquals("Type 2", result.get(1).getInventoryType());

        // Verify that the findAll method was called once
        verify(inventoryRepo, times(1)).findAll();
    }

    @Test
    public void testAddInventory() {
        // Mock data
        Inventory inventory = new Inventory(1L, "New Inventory", 20L, "New Type");
        when(inventoryRepo.insert(inventory)).thenReturn(inventory);

        // Call the service method
        Inventory result = inventoryService.addInventory(inventory);

        // Verify the result
        assertEquals("New Inventory", result.getInventoryName());
        assertEquals(20L, result.getInventoryStock());
        assertEquals("New Type", result.getInventoryType());

        // Verify that the insert method was called once
        verify(inventoryRepo, times(1)).insert(inventory);
    }

    @Test
    public void testGetInventory() {
        // Mock data
        Long inventoryId = 1L;
        Inventory inventory = new Inventory(inventoryId, "Inventory 1", 10L, "Type 1");
        when(inventoryRepo.findById(inventoryId)).thenReturn(Optional.of(inventory));

        // Call the service method
        Optional<Inventory> result = inventoryService.getInventory(inventoryId);

        // Verify the result
        assertEquals("Inventory 1", result.get().getInventoryName());
        assertEquals(10L, result.get().getInventoryStock());
        assertEquals("Type 1", result.get().getInventoryType());

        // Verify that the findById method was called once
        verify(inventoryRepo, times(1)).findById(inventoryId);
    }

    @Test
    public void testUpdateInventory() {
        // Mock data
        Inventory inventory = new Inventory(1L, "Inventory 1", 10L, "Type 1");
        when(inventoryRepo.save(inventory)).thenReturn(inventory);

        // Call the service method
        Inventory result = inventoryService.updateInventory(inventory);

        // Verify the result
        assertEquals("Inventory 1", result.getInventoryName());
        assertEquals(10L, result.getInventoryStock());
        assertEquals("Type 1", result.getInventoryType());

        // Verify that the save method was called once
        verify(inventoryRepo, times(1)).save(inventory);
    }

    @Test
    public void testDeleteInventory() {
        // Mock data
        Long inventoryId = 1L;

        // Call the service method
        String result = inventoryService.deleteInventory(inventoryId);

        // Verify the result
        assertEquals("Deleted employee with ID : " + inventoryId, result);

        // Verify that the deleteById method was called once
        verify(inventoryRepo, times(1)).deleteById(inventoryId);
    }
}
