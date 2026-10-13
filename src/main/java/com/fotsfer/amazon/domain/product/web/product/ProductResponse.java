package com.fotsfer.amazon.domain.product.web.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private int productId;
    private String productName;
    private double productAmount;
}
