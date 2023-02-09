package com.example.javachallengetask.model.dto.mapper;

import com.example.javachallengetask.model.User;
import com.example.javachallengetask.model.dto.ApiCollectiveDto;
import com.example.javachallengetask.model.dto.ApiCollectiveMembershipDto;
import com.example.javachallengetask.model.dto.ApiItemDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    private UserMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UserMapper();
    }

    @Test
    void parseApiItemDto_Ok() {
        User expected = User.builder()
                .tags("java,google,")
                .userName("Jon Skeet")
                .answerCount(35550)
                .location("Romania")
                .questionCount(53)
                .linkToProfile("https://stackoverflow.com/users/22656/jon-skeet")
                .linkToAvatar("https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=256&d=identicon&r=PG")
                .reputation(1384800)
                .build();

        ApiCollectiveDto collectiveDto = ApiCollectiveDto.builder()
                .tags(new String[]{"java,google"})
                .build();
        ApiCollectiveMembershipDto apiCollectiveMembershipDto = ApiCollectiveMembershipDto.builder()
                .collectiveDto(collectiveDto)
                .build();
        ApiItemDto apiItemDto = ApiItemDto.builder()
                .userName("Jon Skeet")
                .answerCount(35550)
                .questionCount(53)
                .reputation(1384800)
                .collectives(new ApiCollectiveMembershipDto[]{apiCollectiveMembershipDto})
                .linkToProfile("https://stackoverflow.com/users/22656/jon-skeet")
                .linkToAvatar("https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=256&d=identicon&r=PG")
                .location("Romania")
                .build();

        User actual = mapper.parseApiItemDto(apiItemDto);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void parseApiItemDto_WithNullOrEmptyValue_Ok() {
        User expected = User.builder()
                .tags("")
                .userName("Jon Skeet")
                .answerCount(0)
                .location("Romania")
                .questionCount(0)
                .linkToProfile("https://stackoverflow.com/users/22656/jon-skeet")
                .linkToAvatar("https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=256&d=identicon&r=PG")
                .reputation(1384800)
                .build();
        ApiItemDto apiItemDto = ApiItemDto.builder()
                .userName("Jon Skeet")
                .answerCount(null)
                .questionCount(null)
                .reputation(1384800)
                .collectives(null)
                .linkToProfile("https://stackoverflow.com/users/22656/jon-skeet")
                .linkToAvatar("https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=256&d=identicon&r=PG")
                .location("Romania")
                .build();

        User actual = mapper.parseApiItemDto(apiItemDto);
        Assertions.assertEquals(expected, actual);
    }
}