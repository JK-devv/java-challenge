package com.example.javachallengetask.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiItemDto {
    @JsonProperty(value = "display_name")
    private String userName;
    @JsonProperty(value = "location")
    private String location;
    @JsonProperty(value = "answer_count")
    private Integer answerCount;
    @JsonProperty(value = "question_count")
    private Integer questionCount;
    @JsonProperty(value = "reputation")
    private Integer reputation;
    @JsonProperty(value = "collectives")
    private ApiCollectiveMembershipDto[] collectives;
    @JsonProperty(value = "link")
    private String linkToProfile;
    @JsonProperty(value = "profile_image")
    private String linkToAvatar;

}
