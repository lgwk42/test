package com.example.serverTest.domain.auth.presentation;

import com.example.serverTest.domain.auth.presentation.dto.request.SignInRequest;
import com.example.serverTest.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.serverTest.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.example.serverTest.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Validated @RequestBody SignUpRequest signUpRequest){
        authService.SignUp(signUpRequest);
    }

    @PostMapping("/sign-in")
    public JsonWebTokenResponse signIn(@Validated @RequestBody SignInRequest signInRequest){
        return authService.SignIn(signInRequest);
    }

}
