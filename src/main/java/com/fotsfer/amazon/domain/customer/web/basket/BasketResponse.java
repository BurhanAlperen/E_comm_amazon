package com.fotsfer.amazon.domain.customer.web.basket;

import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketResponse {
    private int basketId;
    private int userId;
    private int status;
    private double totalPrice;
    private List<BasketProductDto> products;
}
