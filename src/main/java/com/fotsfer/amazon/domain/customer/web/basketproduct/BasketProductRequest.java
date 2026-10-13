package com.fotsfer.amazon.domain.customer.web.basketproduct;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketProductRequest {
    private int count;
    private double basketProductAmount;
}
