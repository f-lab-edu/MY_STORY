package com.moon.myStory.user;

import com.moon.myStory.user.mapper.UserMapper;
import com.moon.myStory.user.model.User;
import com.moon.myStory.user.model.dto.SignUpDto;
import com.moon.myStory.user.model.dto.UpdateUserDto;
import com.moon.myStory.user.service.UserService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    protected void 회원가입(){
        SignUpDto user = SignUpDto.builder()
                .userId("admin2")
                .password("1111")
                .build();
        int result = userService.insertUser(user);
        assertEquals(1 , result);
    }

    @Test
    @Transactional
    protected  void 아이디_회원정보찾기(){
        User user = User.builder()
                .userId("admin")
                .build();
        User temp = userMapper.findByUserId(user.getUserId());
        assertEquals(user.getUserId(), temp.getUserId());
    }

    @Test
    @Transactional
    protected  void 회원정보_수정(){
        UpdateUserDto dto = UpdateUserDto.builder()
                .userId("admin")
                .password("2222")
                .name("진환")
                .phoneNumber("010-1111-1111")
                .email("moon@gamil.com")
                .birth("19930413")
                .profileMessage("hello")
                .build();
        int result = userService.updateUser(dto);
        assertEquals(1, result);
    }
}
