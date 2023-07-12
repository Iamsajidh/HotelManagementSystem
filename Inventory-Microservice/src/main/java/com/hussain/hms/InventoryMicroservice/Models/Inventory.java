package com.hussain.hms.InventoryMicroservice.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
public class Inventory {

	@Id
	private Long inventoryId;

	@NotBlank(message = "Inventory name is required")
	private String inventoryName;

	@NotNull(message = "Inventory stock is required")
	private Long inventoryStock;

	@NotBlank(message = "Inventory type is required")
	private String inventoryType;

	public Inventory() {
		super();
	}

	public Inventory(Long inventoryId, String inventoryName, Long inventoryStock, String inventoryType) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.inventoryStock = inventoryStock;
		this.inventoryType = inventoryType;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public Long getInventoryStock() {
		return inventoryStock;
	}

	public void setInventoryStock(Long inventoryStock) {
		this.inventoryStock = inventoryStock;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", inventoryStock="
				+ inventoryStock + ", inventoryType=" + inventoryType + "]";
	}

}
