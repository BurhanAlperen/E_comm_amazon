package com.fotsfer.amazon.domain.user.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String username;
    private String password;
}
