package com.backend.inventoryservice.Repository;

import com.backend.inventoryservice.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

     List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
