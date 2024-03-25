package com.example.serverTest.domain.user.exception;

import com.example.serverTest.domain.user.exception.error.UserError;
import com.example.serverTest.global.exception.BusinessException;

public class PasswordWrongException extends BusinessException {

    public static final PasswordWrongException EXCEPTION = new PasswordWrongException();

    private PasswordWrongException() {
        super(UserError.PASSWORD_WRONG);
    }
}
