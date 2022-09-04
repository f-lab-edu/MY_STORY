package com.moon.myStory.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String birth;
    private String profileMessage;
    private String profileImageName;
    private String profileImagePath;
    private String role;
}
