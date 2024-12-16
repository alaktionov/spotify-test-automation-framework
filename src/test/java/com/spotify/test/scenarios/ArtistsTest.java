package com.spotify.test.scenarios;

import java.util.List;
import java.util.Map;

import com.spotify.test.BaseApiTest;
import com.spotify.test.steps.ArtistsSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Test scenarios for artists functionality")
public class ArtistsTest extends BaseApiTest {

    @Autowired
    private ArtistsSteps artistsSteps;

    @ParameterizedTest
    @CsvSource({
        "0TnOYISbd1XYRBk9myaseg, Pitbull",
        "1dfeR4HaWDbWqFHLkxsg1d, Queen",
        "3TVXtAsR1Inumwj472S9r4, Drake",
        "06HL4z0CvFAxyc27GXpf02, Taylor Swift",
        "66CXWjxzNUsdJxJ2JdwvnR, Ariana Grande"
    })
    @Story("Get artist information")
    public void testGetArtist(String artistId, String artistName) {
        // When GET request to retrieve artist information is sent
        Response response = artistsSteps.getArtistById(artistId);

        // Then response status code is correct
        response.then().statusCode(200);

        // And all necessary assertions passed
        assertEquals(artistId, response.jsonPath().getString("id"), "Artist id is expected to match");
        assertEquals(artistName, response.jsonPath().getString("name"), "Artist name is expected to match");
        assertEquals("artist", response.jsonPath().getString("type"), "Artist type is expected to be 'artist'");
    }

    @Test
    @Story("Get artist information")
    public void testGetArtists() {
        // Given list of artistIds is identified
        List<String> artistIds = List.of(
            "0TnOYISbd1XYRBk9myaseg",
            "1dfeR4HaWDbWqFHLkxsg1d",
            "3TVXtAsR1Inumwj472S9r4",
            "06HL4z0CvFAxyc27GXpf02",
            "66CXWjxzNUsdJxJ2JdwvnR"
        );

        // When GET request to retrieve artists information is sent
        Response response = artistsSteps.getArtistsByIds(artistIds);

        // Then response status code is correct
        response.then().statusCode(200);

        // And all assertion passed
        List<Map<String, Object>> artists = response.jsonPath().getList("artists");
        assertNotNull(artists, "Artists list should not be null");
        assertEquals(artistIds.size(), artists.size(), "Number of artists in response should match the request");

        for (Map<String, Object> artist : artists) {
            String artistId = (String) artist.get("id");
            assertTrue(artistIds.contains(artistId), "Artist id should be one of the requested IDs");
            assertNotNull(artist.get("name"), "Artist name should not be null for artist ID: " + artistId);
            assertEquals("artist", artist.get("type"), "Artist type should be 'artist' for artist ID: " + artistId);
        }
    }
}