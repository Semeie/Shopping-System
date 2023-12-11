package com.backend.inventoryservice.Service;


import com.backend.inventoryservice.DTO.InventoryResponse;
import com.backend.inventoryservice.Model.Inventory;
import com.backend.inventoryservice.Repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public List<InventoryResponse> IsInStock(List<String> skuCode){
       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                       InventoryResponse.builder()
                               .skuCode(inventory.getSkuCode())
                               .isInStock(inventory.getQuantity() > 0)
                               .build()).toList();
    }
}
