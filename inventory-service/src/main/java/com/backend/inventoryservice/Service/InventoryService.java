package com.backend.inventoryservice.Service;


import com.backend.inventoryservice.Repository.InventoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public boolean isInStock(String skuCode){
       return inventoryRepository.findBySkuCode().isPresent();
    }
}
