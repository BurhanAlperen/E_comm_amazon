package com.fotsfer.amazon.domain.user.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private Integer userId;
    private String username;
    private String password;
}
