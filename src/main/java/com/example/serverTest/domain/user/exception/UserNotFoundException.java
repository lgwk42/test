package com.example.serverTest.domain.user.exception;

import com.example.serverTest.domain.user.exception.error.UserError;
import com.example.serverTest.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException(){
        super(UserError.USER_NOT_FOUND);
    }

}