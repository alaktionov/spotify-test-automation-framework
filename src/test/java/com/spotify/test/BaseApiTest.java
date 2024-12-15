package com.spotify.test;

import com.spotify.test.base.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseApiTest {

    @Autowired
    protected ApiClient apiClient;

}