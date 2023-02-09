package com.example.javachallengetask;


import com.example.javachallengetask.model.dto.ApiResponseDto;
import com.example.javachallengetask.model.dto.mapper.UserMapper;
import com.example.javachallengetask.model.User;
import com.example.javachallengetask.service.HttpClient;
import com.example.javachallengetask.service.UserService;
import com.example.javachallengetask.service.UserServiceImpl;

import java.util.List;

public class JavaChallengeTaskApplication {

    public static void main(String[] args) {
        try {
            UserMapper userMapper = new UserMapper();
            HttpClient httpClient = new HttpClient();
            UserService userService = new UserServiceImpl(httpClient, userMapper);
            List<User> userByCriteries = userService.getUserByCriteries();
            System.out.println("--------------------------------------------------------");
            System.out.println(userByCriteries);
            System.out.println("--------------------------------------------------------");
        } catch (Exception e) {
        e.printStackTrace();
    }

    }
}
