package com.example.serverTest.domain.user.mapper;

import com.example.serverTest.domain.user.domain.UserEntity;
import com.example.serverTest.domain.user.domain.enums.UserRole;
import com.example.serverTest.domain.user.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .userRole(entity.getUserRole())
                .build();
    }

    public UserEntity toCreate(String name, String email, String password){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .userRole(UserRole.USER)
                .build();
    }

}
