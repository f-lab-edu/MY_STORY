package com.moon.myStory.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String birth;
    private String profileMessage;
}
