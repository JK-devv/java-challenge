package com.example.javachallengetask.service;

import com.example.javachallengetask.dto.ApiItemDto;
import com.example.javachallengetask.dto.mapper.UserMapper;
import com.example.javachallengetask.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final Integer FILTER_MIN_REPUTATION = 223;
    private final String FILTER_LOCATION_ROMANIA = "Romania";
    private final String FILTER_LOCATION_MOLDOVA = "Moldova";
    private final Integer FILTER_MIN_ANSWER_COUNT = 1;
    private final List<String> FILTER_TAGS = List.of("java", "net", "docker", "C#");
    private final UserMapper mapper;
    private final List<ApiItemDto> itemDtos;

    public UserServiceImpl(HttpClient httpClient, UserMapper mapper) {
        this.mapper = mapper;
        itemDtos = httpClient.processAndGetApiResponse().getItemResponseDtos();
    }

    @Override
    public List<User> getUserByCriteries() {
        return itemDtos.stream()
                .map(mapper::parseApiItemDto)
                .filter(user -> user.getLocation().equalsIgnoreCase(FILTER_LOCATION_ROMANIA) ||
                        user.getLocation().equalsIgnoreCase(FILTER_LOCATION_MOLDOVA))
                .filter(user -> user.getReputation() >= FILTER_MIN_REPUTATION)
                .filter(user -> user.getAnswerCount() >= FILTER_MIN_ANSWER_COUNT)
                .filter(user -> FILTER_TAGS.stream().anyMatch(tags -> user.getTags().equalsIgnoreCase(tags)))
                .toList();
    }
}
