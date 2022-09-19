package com.moon.myStory.user.mapper;

import com.moon.myStory.user.model.User;
import com.moon.myStory.user.model.dto.DeleteUserDto;
import com.moon.myStory.user.model.dto.SignUpDto;
import com.moon.myStory.user.model.dto.UpdateUserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int insertUser(SignUpDto dto);
    public int deleteUser(DeleteUserDto dto);
    public User findByUserId(String userId);
    public int updateUser(UpdateUserDto dto);
}
