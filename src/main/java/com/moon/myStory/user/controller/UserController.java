package com.moon.myStory.user.controller;

import com.moon.myStory.handler.CustomHandler;
import com.moon.myStory.user.model.dto.SignUpDto;
import com.moon.myStory.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    //회원가입
    @PostMapping("/join")
    public ResponseEntity<SignUpDto> insertUser(@RequestBody SignUpDto dto, BindingResult bindingResult){
        int result = userService.insertUser(dto);

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors() ){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomHandler("유효성검사 오류입니다.", errorMap);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
