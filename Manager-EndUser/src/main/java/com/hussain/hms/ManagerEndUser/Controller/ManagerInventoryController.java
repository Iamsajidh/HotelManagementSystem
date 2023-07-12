package com.hussain.hms.ManagerEndUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hussain.hms.ManagerEndUser.Models.Inventory;
import com.hussain.hms.ManagerEndUser.Models.InventoryList;

@RestController
@RequestMapping("/Manager/Inventory")
public class ManagerInventoryController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getAllInv")
	public InventoryList getInventory() {
		return restTemplate.getForObject("http://localhost:8085/Inventory/getAllInv/", InventoryList.class);
	}

	@GetMapping("/getByInv/{id}")
	public Inventory getInventory(@PathVariable("id") String id) {
		return restTemplate.getForObject("http://localhost:8085/Inventory/getByInv/" + id, Inventory.class);
	}

	@PostMapping("/addInv")
	public Inventory addInventory(@RequestBody Inventory inv) {
		return restTemplate.postForObject("http://localhost:8085/Inventory/addInv/", inv, Inventory.class);
	}

	@PutMapping("/updateInv")
	public Inventory updateInventory(@RequestBody Inventory inv) {
		restTemplate.put("http://localhost:8085/Inventory/updateInv/", inv, Inventory.class);
		return inv;
	}

	@DeleteMapping("/deleteByInv/{id}")
	public String deleteInventory(@PathVariable("id") String id) {
		restTemplate.delete("http://localhost:8085/Inventory/deleteByInv/" + id);
		return "Deleted room " + id;
	}
}
