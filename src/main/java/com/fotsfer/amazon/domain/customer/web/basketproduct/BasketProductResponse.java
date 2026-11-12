package com.fotsfer.amazon.domain.customer.web.basketproduct;

import com.fotsfer.amazon.domain.base.BaseResponse;
import com.fotsfer.amazon.domain.customer.impl.basket.BasketProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketProductResponse extends BaseResponse {
    private int count;
    private double basketProductAmount;

    public BasketProductResponse(Integer code, String message){
        super(code,message);
    }
    public BasketProductResponse(){

    }
}
