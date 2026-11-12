package com.fotsfer.amazon.domain.customer.web.basket;

import com.fotsfer.amazon.domain.base.BaseResponse;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BasketResponse extends BaseResponse {
    private int basketId;
    private int userId;
    private int status;
    private double totalPrice;
    private List<BasketProductDto> products;

    public BasketResponse(Integer code, String message){
        super(code,message);
    }
    public BasketResponse(){

    }

}
