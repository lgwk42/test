package com.example.serverTest.global.exception.error;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {

    HttpStatus getStatus();
    String getMessage();

}
