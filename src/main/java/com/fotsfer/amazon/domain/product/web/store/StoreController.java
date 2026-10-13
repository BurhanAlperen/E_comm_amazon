package com.fotsfer.amazon.domain.product.web.store;

import com.fotsfer.amazon.domain.product.api.store.StoreDto;
import com.fotsfer.amazon.domain.product.api.store.StoreService;
import com.fotsfer.amazon.domain.product.impl.store.Store;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class StoreController {
    @Autowired
    StoreService service;

    @PostMapping
    public StoreResponse save(@RequestBody StoreRequest store){
        StoreDto dto = service.save(toDto(store));
        return toResponse(dto);
    }
    @PutMapping("/{id}")
    public StoreResponse update(@RequestBody StoreRequest store, @PathVariable int id){
        StoreDto dto = service.update(toDto(store), id);
        return toResponse(dto);
    }
    @GetMapping("/{id}")
    public StoreResponse findById(@PathVariable int id){
        StoreDto dto = service.getStoreById(id);
        return toResponse(dto);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(id);
    }

    public StoreResponse toResponse(StoreDto dto) {
        StoreResponse response = new StoreResponse();
        response.setStoreName(dto.getStoreName());
        response.setRate(dto.getRate());
        return response;
    }

    public StoreDto toDto(StoreRequest request) {
        StoreDto dto = new StoreDto();
        dto.setStoreName(request.getStoreName());
        dto.setRate(request.getRate());
        return dto;
    }
}
