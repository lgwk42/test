package com.example.serverTest.domain.user.exception;

import com.example.serverTest.domain.user.exception.error.UserError;
import com.example.serverTest.global.exception.BusinessException;

public class UserExistException extends BusinessException {

    public static final UserExistException EXCEPTION = new UserExistException();

    private UserExistException(){
        super(UserError.USER_EXIST);
    }

}

