package com.fotsfer.amazon.domain.base;

public class BaseResponse {
    public Integer code = 200;
    public String message ;

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse() {
    }
}
