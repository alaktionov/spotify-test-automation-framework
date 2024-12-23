package com.spotify.test.scenarios.ui;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Epic("UI - Test scenarios for login functionality")
public class LoginTest extends BaseUITest {

    @BeforeEach
    public void setup() {
        navigationHelper.navigateToHomePage();
    }

    @Test
    public void testLogin() {
        loginHelper.loginAsAdmin();
    }
}
