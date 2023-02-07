package com.example.javachallengetask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiItemResponseDto {
    @JsonProperty(value = "display_name")
    private String userName;

}
