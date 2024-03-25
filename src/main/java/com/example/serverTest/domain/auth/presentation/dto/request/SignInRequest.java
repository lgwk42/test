package com.example.serverTest.domain.auth.presentation.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    private String email;
    private String password;

}
