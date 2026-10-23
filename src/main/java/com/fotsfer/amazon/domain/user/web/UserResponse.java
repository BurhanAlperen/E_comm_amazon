package com.fotsfer.amazon.domain.user.web;

import com.fotsfer.amazon.domain.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends BaseResponse {
    private Integer userId;
    private String username;


    public UserResponse(Integer code, String message) {
        super(code, message);
    }

    public UserResponse() {

    }
}
