package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.map.UserMap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public Optional<UserMap> getUser(String userId) {
        UserMap userDto = new UserMap();
        userDto.setUserId(userId);
        return userMapper.login(userDto);
    }
}
