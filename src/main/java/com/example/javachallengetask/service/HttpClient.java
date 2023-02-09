package com.example.javachallengetask.service;

import com.example.javachallengetask.dto.ApiItemDto;
import com.example.javachallengetask.dto.ApiResponseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpClient {

    private static final Integer MAX_PAGE_WITHOUT_TOKEN = 25;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @SneakyThrows
    public ApiResponseDto processAndGetApiResponse() {
        List<ApiItemDto> items = processApiItems();
        return ApiResponseDto.builder()
                .itemResponseDtos(items)
                .build();
    }

    private List<ApiItemDto> processApiItems() {
        List<ApiItemDto> items = new ArrayList<>();
        for (int i = 1; i < MAX_PAGE_WITHOUT_TOKEN; i++) {
            String url = String.format("https://api.stackexchange.com/2.3/users?page=%s&pagesize=100&order=desc&sort=reputation&site=stackoverflow&filter=!)scY3M2EMD(iNsngZ1(J", i);
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                items.addAll(objectMapper.readValue(response.getEntity().getContent(), ApiResponseDto.class).getItemResponseDtos());
            //    url = processUrl(url, i + 1);
            } catch (IOException e) {
                throw new RuntimeException("Can`t fetch into from URL " + url);
            }
        }
        return items;
    }

//    private String processUrl(String url, int pageIndex) {
//        String newUrl =
////        String newUrl = "";
////        int indexOfReplacedPage = url.indexOf("=") + 1;
////        if (pageIndex > 10) {
////            newUrl = url.substring(0, indexOfReplacedPage) + pageIndex + url.substring(indexOfReplacedPage + 1);
////        }
//
//        return
//    }

}
