package com.example.javachallengetask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiCollectiveDto {
    @JsonProperty(value = "tags")
    private String[] tags;
}
