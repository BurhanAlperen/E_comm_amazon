package com.fotsfer.amazon.domain.product.web.store;

import com.fotsfer.amazon.domain.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreResponse extends BaseResponse {
    private String storeName;
    private double rate;

    public StoreResponse(Integer code, String message){
        super(code, message);
    }

    public StoreResponse(){

    }

}
