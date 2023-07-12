package com.hussain.hms.InventoryMicroservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.InventoryMicroservice.Models.Inventory;

@Repository
public interface InventoryRepo extends MongoRepository<Inventory, Long> {

}