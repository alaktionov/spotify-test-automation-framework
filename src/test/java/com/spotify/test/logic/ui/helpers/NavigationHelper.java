package com.spotify.test.logic.ui.helpers;

import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class NavigationHelper extends BaseHelper {

    @Step("Open Home page")
    public void navigateToHomePage() {
        driver.get(appConfig.getBaseUrl());
    }

    @Step("Open {url}")
    public void navigateTo(String url) {
        driver.get(url);
    }

}
