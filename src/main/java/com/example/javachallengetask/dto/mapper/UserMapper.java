package com.example.javachallengetask.dto.mapper;

import com.example.javachallengetask.dto.ApiCollectiveDto;
import com.example.javachallengetask.dto.ApiItemDto;
import com.example.javachallengetask.model.User;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UserMapper {

    public User parseApiItemDto(ApiItemDto apiItemDto) {
        return User.builder()
                .userName(apiItemDto.getUserName())
                .linkToAvatar(apiItemDto.getLinkToAvatar())
                .answerCount(apiItemDto.getAnswerCount())
                .linkToProfile(apiItemDto.getLinkToProfile())
                .questionCount(apiItemDto.getQuestionCount())
                .location(apiItemDto.getLocation())
                .tags(Arrays.stream(apiItemDto.getCollectives())
                        .flatMap(collectives -> Arrays.stream(collectives.getCollectiveDto().getTags()))
                        .collect(Collectors.joining()))
                .build();

    }
}
