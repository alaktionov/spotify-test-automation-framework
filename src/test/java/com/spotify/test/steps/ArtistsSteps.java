package com.spotify.test.steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spotify.test.base.ApiClient;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArtistsSteps {

    private final ApiClient apiClient;

    @Step("Retrieve artist information by artistId: {artistId}")
    public Response getArtistById(String artistId) {
        log.info("Retrieve artist information by artistId: {}", artistId);
        return apiClient.sendRequest("GET", String.format("/artists/%s", artistId));
    }

    @Step("Retrieve artists information by list of artistIds: {artistId}")
    public Response getArtistsByIds(List<String> artistIds) {
        log.info("Retrieve artists information by list of artistIds: {}", artistIds);
        Map<String, Object> params = new HashMap<>();
        params.put("ids", String.join(",", artistIds));
        return apiClient.sendRequest("GET", "/artists", params);
    }
}
