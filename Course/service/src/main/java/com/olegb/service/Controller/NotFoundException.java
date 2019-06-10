package com.olegb.service.Controller;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus()
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message , UUID id){
        super("Error 404: Could not find "+message+" " + id);
    }
}
