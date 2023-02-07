package com.example.javachallengetask;

import com.example.javachallengetask.dto.ApiResponseDto;

import com.example.javachallengetask.service.HttpClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootApplication
public class JavaChallengeTaskApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(JavaChallengeTaskApplication.class, args);

        HttpClient client = new HttpClient();
        ApiResponseDto users = client.get();
        System.out.println(users);
    }
}
