package com.spotify.test.scenarios.api;

import com.spotify.test.BaseTest;
import com.spotify.test.logic.api.base.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseApiTest extends BaseTest {

    @Autowired
    protected ApiClient apiClient;

}
