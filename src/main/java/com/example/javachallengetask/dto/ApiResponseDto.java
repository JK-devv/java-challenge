package com.example.javachallengetask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponseDto {
    @JsonProperty(value = "items")
    private List<ApiItemResponseDto> itemResponseDtos;
}
