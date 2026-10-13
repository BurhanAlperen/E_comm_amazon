package com.fotsfer.amazon.domain.product.impl.store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findStoreByStoreId(int storeId);
}
