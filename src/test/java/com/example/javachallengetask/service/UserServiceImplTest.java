package com.example.javachallengetask.service;

import com.example.javachallengetask.model.User;
import com.example.javachallengetask.model.dto.ApiCollectiveDto;
import com.example.javachallengetask.model.dto.ApiCollectiveMembershipDto;
import com.example.javachallengetask.model.dto.ApiItemDto;
import com.example.javachallengetask.model.dto.ApiResponseDto;
import com.example.javachallengetask.model.dto.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserServiceImpl service;
    private HttpClient httpClient;
    private UserMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UserMapper();
        httpClient = Mockito.mock(HttpClient.class);
        service = new UserServiceImpl(httpClient, mapper);
    }

    @Test
    void getUserByCriteries_Ok() {
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
        List<ApiItemDto> mockediIemsDtos = new ArrayList<>();
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
        mockediIemsDtos.add(apiItemDto);
        ApiResponseDto mockedApiResponseDto = ApiResponseDto.builder()
                .itemResponseDtos(mockediIemsDtos)
                .build();
        when(httpClient.processAndGetApiResponse()).thenReturn(mockedApiResponseDto);
        List<User> actual = service.getUserByCriteries();
        Assertions.assertEquals(expected.getUserName(), actual.get(0).getUserName());
        verify(httpClient, times(1)).processAndGetApiResponse();
    }
}