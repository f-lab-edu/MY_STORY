package com.moon.myStory.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CustomHandler.class)
    public Map<String, String> validException(CustomHandler e){
        return e.getErrorMap();
    }
}
