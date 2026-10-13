package com.fotsfer.amazon.domain.customer.api.basketProduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketProductDto {
    private int basketProductId;
    private int count;
    private double basketProductAmount;
    private int basketId;
    private int productId;
}
