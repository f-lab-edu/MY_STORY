package com.moon.myStory.user.controller;

import com.moon.myStory.handler.CustomHandler;
import com.moon.myStory.user.model.User;
import com.moon.myStory.user.model.dto.DeleteUserDto;
import com.moon.myStory.user.model.dto.SignUpDto;
import com.moon.myStory.user.model.dto.UpdateUserDto;
import com.moon.myStory.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<SignUpDto> insertUser(@Valid @RequestBody SignUpDto dto, BindingResult bindingResult){
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

    //회원탈퇴
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserDto dto){
        userService.deleteUser(dto);
        return new ResponseEntity<>("삭제완료", HttpStatus.OK);
    }

    //회원수정
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUserDto dto){
        userService.updateUser(dto);
        return new ResponseEntity<>("수정완료", HttpStatus.OK);
    }
}
