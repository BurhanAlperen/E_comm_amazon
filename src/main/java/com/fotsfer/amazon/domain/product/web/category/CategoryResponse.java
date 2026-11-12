package com.fotsfer.amazon.domain.product.web.category;

import com.fotsfer.amazon.domain.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse extends BaseResponse {
    private String categoryName;

    public CategoryResponse(Integer code, String message){
        super(code,message);
    }
    public CategoryResponse(){

    }


}
