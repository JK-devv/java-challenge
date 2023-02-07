package com.example.javachallengetask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiItemDto {
    @JsonProperty(value = "display_name")
    private String userName;
    @JsonProperty(value = "location")
    private String location;
    @JsonProperty(value = "answer_count")
    private Integer answerCount;
    @JsonProperty(value = "question_count")
    private Integer questionCount;
    @JsonProperty(value = "collectives")
    private ApiCollectiveMembershipDto[] collectives;
    @JsonProperty(value = "link")
    private String linkToProfile;
    @JsonProperty(value = "profile_image")
    private String linkToAvatar;

}
