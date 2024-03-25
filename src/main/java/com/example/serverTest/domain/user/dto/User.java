package com.example.serverTest.domain.user.dto;

import com.example.serverTest.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;

}