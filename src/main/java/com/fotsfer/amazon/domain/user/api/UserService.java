package com.fotsfer.amazon.domain.user.api;

import com.fotsfer.amazon.domain.user.impl.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);
    UserDto save(UserDto user);
    UserDto update(Integer id, UserDto user);
    void delete(int id);
    List<UserDto> findAll();
    String userLogin(String username, String password);
}
