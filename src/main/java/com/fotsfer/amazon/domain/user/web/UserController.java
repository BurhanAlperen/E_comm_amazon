package com.fotsfer.amazon.domain.user.web;

import com.fotsfer.amazon.domain.user.api.UserDto;
import com.fotsfer.amazon.domain.user.api.UserService;
import com.fotsfer.amazon.domain.user.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest user) {
        UserDto dto = service.save(toDto(user));
        return toResponse(dto);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserRequest user) {
        return service.userLogin(user.getUsername(), user.getPassword());
    }

    @GetMapping
    public List<UserResponse> findAll() {
        List<UserDto> dtoList = service.findAll();
        List<UserResponse> responseList = new ArrayList<>();
        for (int i = 0; i < dtoList.size(); i++) {
            responseList.add(toResponse(dtoList.get(i)));
        }
        return responseList;
    }

    @GetMapping("/{id}")
    public User find(@PathVariable Integer id) {
        return service.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Integer id, @RequestBody UserRequest user) {
        return toResponse(service.update(id,toDto(user)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    public UserResponse toResponse(UserDto dto) {
        UserResponse response = new UserResponse();
        response.setUserId(dto.getUserId());
        response.setUsername(dto.getUsername());
        return response;
    }

    public UserDto toDto(UserRequest user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
