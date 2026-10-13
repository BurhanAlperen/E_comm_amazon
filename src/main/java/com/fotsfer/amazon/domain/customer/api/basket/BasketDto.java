package com.fotsfer.amazon.domain.customer.api.basket;

import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketDto {
    private Integer basketId;
    private int userId;
    private int status;
    private List<BasketProductDto> products;
    private double totalPrice;
}
