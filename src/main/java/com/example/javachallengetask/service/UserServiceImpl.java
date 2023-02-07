package com.example.javachallengetask.service;

import com.example.javachallengetask.dto.ApiItemDto;
import com.example.javachallengetask.dto.mapper.UserMapper;
import com.example.javachallengetask.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final HttpClient httpClient;
    private final UserMapper mapper;
    private final List<ApiItemDto> itemDtos;

    public UserServiceImpl(HttpClient httpClient, UserMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
        itemDtos = httpClient.get().getItemResponseDtos();
    }

    @Override
    public List<User> getUserByCriteries() {
        return itemDtos.stream()
                .map(mapper::parseApiItemDto)
                .toList();
    }
}
