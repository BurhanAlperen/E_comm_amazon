package com.fotsfer.amazon.domain.product.api.store;

import com.fotsfer.amazon.domain.product.impl.category.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StoreDto {
    private int storeId;
    private String storeName;
    private double rate;
    private List<Category> categoryList;
}
