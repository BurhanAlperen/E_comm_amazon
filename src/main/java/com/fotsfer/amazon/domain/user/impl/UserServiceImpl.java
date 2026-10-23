package com.fotsfer.amazon.domain.user.impl;

import com.fotsfer.amazon.domain.base.BaseResponse;
import com.fotsfer.amazon.domain.exception.BusinessException;
import com.fotsfer.amazon.domain.user.api.UserDto;
import com.fotsfer.amazon.domain.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    //Create
    @Override
    public UserDto save(UserDto user) {
        User entity = repository.save(toEntity(user));
        return toDto(entity);
    }

    //Update
    @Override
    public UserDto update(Integer id, UserDto user) {
        User existingUser = repository.findById(id).get();
        if (existingUser == null){
            throw new IllegalArgumentException("User not found");
        }
        user.setUsername(existingUser.getUsername());
        user.setPassword(existingUser.getPassword());
        User updatedUser = repository.save(existingUser);
        return toDto(updatedUser);
    }

    //Delete
    @Override
    public void delete(int id) {
        User user = repository.findUserByUserId(id);
        if (user != null) {
            repository.delete(user);
        }
    }

    @Override
    public BaseResponse userLogin(String username, String password) {
        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new BusinessException(new BaseResponse(2001, "Kullanıcı adı veya şifre boş olamaz"));
        }
        User user = repository.findUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new BusinessException(new BaseResponse(2005, "Kullanıcı Adı ve Şifrenizi Kontrol Ederek Yeniden Deneyiniz"));
        }
        return new BaseResponse(200, "Sisteme Giriş Yapıldı");
    }

    //Read
    @Override
    public User findUserById(int id){
       return repository.findUserByUserId(id);
    }

    //Read All
    public List<UserDto> findAll(){
        List<User> users = repository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        for(int i =0;i<users.size();i++){
            dtoList.add(toDto(users.get(i)));
        }
        return dtoList;
    }

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public static User toEntity(UserDto dto){
        User entity = new User();
        if (dto.getUserId() != null) {
            entity.setUserId(dto.getUserId());
        }
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        return entity;
    }

}
