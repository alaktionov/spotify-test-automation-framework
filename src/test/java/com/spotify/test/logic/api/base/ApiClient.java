package com.spotify.test.logic.api.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;

import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@Slf4j
public class ApiClient {

    private final String clientId;
    private final String clientSecret;
    private final String baseApiUrl;
    private final String accessToken;

    private static final String GRANT_TYPE = "client_credentials";
    private static final String ACCESS_TOKEN_ENDPOINT = "https://accounts.spotify.com/api/token";

    public ApiClient(String baseApiUrl, String clientId, String clientSecret) {
        this.baseApiUrl = baseApiUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessToken = retrieveAccessToken();
    }

    private String retrieveAccessToken() {
        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        String authorizationHeader = "Basic " + encodedCredentials;

        log.info("Requesting access token from Spotify API");
        Response response = RestAssured.given()
            .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
            .header(HttpHeaders.CONTENT_TYPE, ContentType.URLENC)
            .formParam("grant_type", GRANT_TYPE)
            .when()
            .post(ACCESS_TOKEN_ENDPOINT);

        if (response.statusCode() == 200) {
            log.info("Access token retrieved successfully: {}", response.asString());
            return response.jsonPath().getString("access_token");
        }
        else {
            log.error("Failed to fetch access token: Status Code = {}", response.statusCode());
            throw new RuntimeException("Failed to fetch access token: " + response.statusCode());
        }
    }

    public Response sendRequest(String method, String endpoint, Map<String, Object> params) {
        Response response = RestAssured.given()
            .filters(new AllureRestAssured())
            .baseUri(baseApiUrl)
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
            .params(params)
            .request(method, endpoint);
        log.debug("Response Body: {}", response.asString());
        return response;
    }

    public Response sendRequest(String method, String endpoint) {
        return sendRequest(method, endpoint, Collections.emptyMap());
    }
}