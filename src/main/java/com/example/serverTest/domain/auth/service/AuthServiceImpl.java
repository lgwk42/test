package com.example.serverTest.domain.auth.service;

import com.example.serverTest.domain.auth.presentation.dto.request.SignInRequest;
import com.example.serverTest.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.serverTest.domain.auth.presentation.dto.response.JsonWebTokenResponse;
import com.example.serverTest.domain.user.domain.enums.UserRole;
import com.example.serverTest.domain.user.domain.repository.UserRepository;
import com.example.serverTest.domain.user.exception.PasswordWrongException;
import com.example.serverTest.domain.user.exception.UserExistException;
import com.example.serverTest.domain.user.mapper.UserMapper;
import com.example.serverTest.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public void SignUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw UserExistException.EXCEPTION;
        userRepository.save(userMapper.toCreate(
                request.getName(),
                request.getEmail(),
                encoder.encode(request.getPassword())));
    }

    @Transactional
    @Override
    public JsonWebTokenResponse SignIn(SignInRequest request) {
        String userPassword = userRepository.getByEmail(request.getEmail()).getPassword();
        if (!encoder.matches(request.getPassword(), userPassword))
            throw PasswordWrongException.EXCEPTION;

        return JsonWebTokenResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail(), UserRole.USER))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail(), UserRole.USER))
                .build();
    }

}
