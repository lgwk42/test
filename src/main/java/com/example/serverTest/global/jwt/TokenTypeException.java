package com.example.serverTest.global.jwt;

import com.example.serverTest.global.exception.BusinessException;

public class TokenTypeException extends BusinessException {

    public static final TokenTypeException EXCEPTION = new TokenTypeException();

    private TokenTypeException() {
        super(JwtTokenError.JWT_TOKEN_ERROR);
    }

}

