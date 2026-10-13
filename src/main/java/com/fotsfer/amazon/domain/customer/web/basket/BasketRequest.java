package com.fotsfer.amazon.domain.customer.web.basket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketRequest {
    private int userId;
    private int productId;
    private int count;
}
