package com.fotsfer.amazon.domain.exception;

import com.fotsfer.amazon.domain.base.BaseResponse;

public class BusinessException extends RuntimeException {
    public BaseResponse baseResponse;

    public BusinessException(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }
}
