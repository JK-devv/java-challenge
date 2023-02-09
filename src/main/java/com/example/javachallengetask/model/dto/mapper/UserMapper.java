package com.example.javachallengetask.model.dto.mapper;

import com.example.javachallengetask.model.dto.ApiItemDto;
import com.example.javachallengetask.model.User;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UserMapper {

    public User parseApiItemDto(ApiItemDto apiItemDto) {
        return User.builder()
                .userName(apiItemDto.getUserName() != null ? apiItemDto.getUserName() : "")
                .linkToAvatar(apiItemDto.getLinkToAvatar() != null ? apiItemDto.getLinkToAvatar() : "")
                .answerCount(apiItemDto.getAnswerCount() != null ? apiItemDto.getAnswerCount() : 0)
                .linkToProfile(apiItemDto.getLinkToProfile() != null ? apiItemDto.getLinkToProfile() : "")
                .questionCount(apiItemDto.getQuestionCount() != null ? apiItemDto.getQuestionCount() : 0)
                .location(apiItemDto.getLocation() != null ? apiItemDto.getLocation() : "")
                .reputation(apiItemDto.getReputation() != null ? apiItemDto.getReputation() : 0)
                .tags(apiItemDto.getCollectives() == null || apiItemDto.getCollectives().length == 0 ? "" : Arrays.stream(apiItemDto.getCollectives())
                        .flatMap(collectives -> Arrays.stream(collectives.getCollectiveDto().getTags()))
                        .map(tags -> tags + ",")
                        .collect(Collectors.joining()))
                .build();

    }
}
