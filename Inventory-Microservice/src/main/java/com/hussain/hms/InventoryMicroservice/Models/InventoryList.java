package com.hussain.hms.InventoryMicroservice.Models;

import java.util.List;

public class InventoryList {

	private List<Inventory> allstaff;

	public List<Inventory> getAllstaff() {
		return allstaff;
	}

	public void setAllstaff(List<Inventory> allstaff) {
		this.allstaff = allstaff;
	}

}
