package com.example.javachallengetask.service;

import com.example.javachallengetask.model.User;
import com.example.javachallengetask.model.dto.ApiItemDto;
import com.example.javachallengetask.model.dto.mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final Integer FILTER_MIN_REPUTATION = 223;
    private static final String FILTER_LOCATION_ROMANIA = "Romania";
    private static final String FILTER_LOCATION_MOLDOVA = "Moldova";
    private static final Integer FILTER_MIN_ANSWER_COUNT = 1;
    private static final List<String> FILTER_TAGS = List.of("java", "net ", "docker", "C#");
    private final UserMapper mapper;
    private final HttpClient client;

    public UserServiceImpl(HttpClient client, UserMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public List<User> getUserByCriteries() {
        List<ApiItemDto> itemResponseDtos = client.processAndGetApiResponse().getItemResponseDtos();
        return itemResponseDtos.stream()
                .map(mapper::parseApiItemDto)
                .filter(user -> user.getLocation().contains(FILTER_LOCATION_ROMANIA) ||
                        user.getLocation().contains(FILTER_LOCATION_MOLDOVA))
                .filter(user -> FILTER_TAGS.stream().anyMatch(tags -> user.getTags().contains(tags)))
                .filter(user -> user.getReputation() >= FILTER_MIN_REPUTATION)
                .filter(user -> user.getAnswerCount() >= FILTER_MIN_ANSWER_COUNT)
                .toList();
    }
}
