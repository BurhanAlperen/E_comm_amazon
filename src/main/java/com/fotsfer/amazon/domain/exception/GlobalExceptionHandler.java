package com.fotsfer.amazon.domain.exception;

import com.fotsfer.amazon.domain.base.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public BaseResponse handleBusinessException(BusinessException ex) {
        return ex.baseResponse;
    }


}
