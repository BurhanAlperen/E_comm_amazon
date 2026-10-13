package com.fotsfer.amazon.domain.product.api.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int productId;
    private String productName;
    private double productAmount;
}
