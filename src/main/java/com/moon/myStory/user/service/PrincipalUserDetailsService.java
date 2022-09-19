package com.moon.myStory.user.service;

import com.moon.myStory.user.mapper.UserMapper;
import com.moon.myStory.user.model.PrincipalUserDetails;
import com.moon.myStory.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUserId(username);
        return new PrincipalUserDetails(user);
    }
}
