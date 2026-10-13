package com.fotsfer.amazon.domain.product.web.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private int productId;
    private String productName;
    private double productAmount;
}
