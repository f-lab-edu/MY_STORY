package com.moon.myStory.handler;


import java.util.Map;

public class CustomHandler extends RuntimeException{
    private Map<String, String> errorMap;

    public CustomHandler(String message, Map<String, String> errorMap){
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap(){
        return errorMap;
    }
}
