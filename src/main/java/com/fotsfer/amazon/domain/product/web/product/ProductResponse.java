package com.fotsfer.amazon.domain.product.web.product;

import com.fotsfer.amazon.domain.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse extends BaseResponse {
    private int productId;
    private String productName;
    private double productAmount;

    public ProductResponse(int code, String message){
        super(code,message);
    }

    public ProductResponse(){

    }



}
