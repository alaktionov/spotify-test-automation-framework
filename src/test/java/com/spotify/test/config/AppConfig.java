package com.spotify.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spotify.test.base.ApiClient;

@Configuration
public class AppConfig {

    @Value("${app.clientId}")
    private String clientId;

    @Value("${app.clientSecret}")
    private String clientSecret;

    @Value("${app.baseApiUrl}")
    private String baseApiUrl;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient(clientId, clientSecret, baseApiUrl);
    }
}