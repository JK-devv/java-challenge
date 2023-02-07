package com.example.javachallengetask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiCollectiveMembershipDto {
    @JsonProperty(value = "collective")
    private ApiCollectiveDto collectiveDto;
}
