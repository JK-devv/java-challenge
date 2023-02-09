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
                .answerCount(apiItemDto.getAnswerCount() != null ? apiItemDto.getAnswerCount() : 0)
                .linkToProfile(apiItemDto.getLinkToProfile())
                .questionCount(apiItemDto.getQuestionCount() != null ? apiItemDto.getQuestionCount() : 0)
                .location(apiItemDto.getLocation())
                .tags(apiItemDto.getCollectives() != null ? Arrays.stream(apiItemDto.getCollectives())
                        .flatMap(collectives -> Arrays.stream(collectives.getCollectiveDto().getTags()))
                        .collect(Collectors.joining()) : "")
                .build();

    }
}
