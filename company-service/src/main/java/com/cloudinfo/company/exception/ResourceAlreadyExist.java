package com.cloudinfo.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExist extends RuntimeException{
    private String message;

    public ResourceAlreadyExist(String message) {
        super(message);
        this.message = message;
    }
}