package com.moon.myStory.user.service;

import com.moon.myStory.user.mapper.UserMapper;
import com.moon.myStory.user.model.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    //비밀번호 암호화, 권한 설정
    public int insertUser(SignUpDto dto){
        String encPassword = bCryptPasswordEncoder.encode(dto.getPassword());
        dto.setPassword(encPassword);
        dto.setRole("GUEST"); //게스트권한
        return userMapper.insertUser(dto);
    }
}