package com.spotify.test;

import com.spotify.test.logic.common.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    @Autowired
    protected AppConfig appConfig;

}