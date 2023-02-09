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
public class ApiCollectiveMembershipDto {
    @JsonProperty(value = "collective")
    private ApiCollectiveDto collectiveDto;
}
