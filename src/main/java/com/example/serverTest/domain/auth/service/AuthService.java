package com.example.serverTest.domain.auth.service;

import com.example.serverTest.domain.auth.presentation.dto.request.SignInRequest;
import com.example.serverTest.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.serverTest.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    @Transactional
    void SignUp(SignUpRequest request);

    @Transactional
    JsonWebTokenResponse SignIn(SignInRequest request);

}
