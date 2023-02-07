package com.example.javachallengetask.model;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String location;
    private Integer answerCount;
    private Integer questionCount;
   // private String tags;
    private String linkToProfile;
    private String linkToAvatar;
}
