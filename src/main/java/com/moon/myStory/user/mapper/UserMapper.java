package com.moon.myStory.user.mapper;

import com.moon.myStory.user.model.dto.SignUpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int insertUser(SignUpDto dto);
}
