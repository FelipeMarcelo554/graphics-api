package com.felipemarcelo554.graphicsAPI.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginClient {

    private RestTemplate restTemplate;

    @Autowired
    public LoginClient(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .rootUri("https://graphics-login-api.herokuapp.com/api")
                .build();
    }


    public boolean isValid(String jwt) {
        ResponseEntity<Boolean> response;
        try {
            response = restTemplate.getForEntity("/auth/token/{jwt}", Boolean.class, jwt);
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return response.getBody();
    }
}
