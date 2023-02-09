package com.example.javachallengetask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userName;
    private String location;
    private Integer answerCount;
    private Integer questionCount;
    private String tags;
    private Integer reputation;
    private String linkToProfile;
    private String linkToAvatar;
}
