package com.cloudinfo.jobs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String fieldName;
    private Long value;

    public ResourceNotFoundException(String resource, String fieldName, Long value) {
        super(String.format("%s not found with given %s %d", resource,fieldName, value));
        this.resource = resource;
        this.fieldName = fieldName;
        this.value = value;
    }
}
