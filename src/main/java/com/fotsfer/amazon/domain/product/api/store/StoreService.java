package com.fotsfer.amazon.domain.product.api.store;

public interface StoreService {
    public StoreDto save (StoreDto store);
    public StoreDto getStoreById(int id);
    public StoreDto update (StoreDto store,Integer storeId);
    public void delete (Integer id);
}
