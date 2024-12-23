package com.spotify.test.logic.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.spotify.test.logic.api.base.ApiClient;

@Configuration
@Getter
public class AppConfig {

    @Value("${app.ui.baseUrl}")
    private String baseUrl;

    @Value("${app.ui.username}")
    private String username;

    @Value("${app.ui.password}")
    private String password;

    @Value("${app.api.clientId}")
    private String clientId;

    @Value("${app.api.clientSecret}")
    private String clientSecret;

    @Value("${app.api.baseApiUrl}")
    private String baseApiUrl;

    @Bean
    public ApiClient apiClient() {
        return new ApiClient(baseApiUrl, clientId, clientSecret);
    }
}