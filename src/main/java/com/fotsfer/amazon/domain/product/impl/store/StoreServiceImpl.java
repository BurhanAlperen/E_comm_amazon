package com.fotsfer.amazon.domain.product.impl.store;

import com.fotsfer.amazon.domain.product.api.store.StoreDto;
import com.fotsfer.amazon.domain.product.api.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository repository;

    public StoreDto save (StoreDto store) {
        Store entity = repository.save(toEntity(store));
        return toDto(entity);
    }

    public StoreDto getStoreById(int id) {
        Store entity = repository.findStoreByStoreId(id);
        return toDto(entity);
    }

    public StoreDto update (StoreDto store,Integer storeId) {
        Store existingStore = repository.findById(storeId)
                .orElseThrow(()-> new IllegalArgumentException("Store that id with : " + storeId + " Not found"));
        existingStore.setStoreName(store.getStoreName());
        existingStore.setRate(store.getRate());
        Store updatedStore = repository.save(existingStore);
        return toDto(updatedStore);
    }

    public void delete (Integer id) {
        Store entity = repository.findById(id).get();
        repository.delete(entity);
    }



    public static StoreDto toDto(Store store) {
        StoreDto storeDto = new StoreDto();
        storeDto.setStoreName(store.getStoreName());
        storeDto.setRate(store.getRate());
        return storeDto;
    }

    public static Store toEntity(StoreDto store) {
        Store entity = new Store();
        entity.setStoreName(store.getStoreName());
        entity.setRate(store.getRate());
        return entity;
    }
}
