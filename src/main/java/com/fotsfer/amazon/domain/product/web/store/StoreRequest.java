package com.fotsfer.amazon.domain.product.web.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    private int storeId;
    private String storeName;
    private double rate;
}
