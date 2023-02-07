package com.example.javachallengetask.service;

import com.example.javachallengetask.dto.ApiResponseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class HttpClient {
    private final String URL = "https://api.stackexchange.com/2.3/users?order=desc&sort=reputation&site=stackoverflow&filter=!LnNkvq16GJcA8yF9tv4xa(";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @SneakyThrows
    public ApiResponseDto get(){
        HttpGet request = new HttpGet(URL);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return objectMapper.readValue(response.getEntity().getContent(), ApiResponseDto.class);
        } catch (IOException e) {
            throw new RuntimeException("Can`t fetch into from URL " + URL);
        }
    }

}
