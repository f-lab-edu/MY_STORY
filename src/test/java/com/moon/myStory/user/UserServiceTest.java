package com.moon.myStory.user;

import com.moon.myStory.user.model.User;
import com.moon.myStory.user.model.dto.SignUpDto;
import com.moon.myStory.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    protected void 회원가입(){
        SignUpDto user = SignUpDto.builder()
                .userId("admin2")
                .password("1111")
                .build();
        int result = userService.insertUser(user);
        Assertions.assertEquals(1 , result);
    }
}
