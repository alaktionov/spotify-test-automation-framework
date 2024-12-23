package com.spotify.test.logic.ui.helpers;

import com.spotify.test.logic.ui.pages.HomePage;
import com.spotify.test.logic.ui.pages.LoginPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginHelper extends BaseHelper {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Step("Login as a user: {username}")
    public void loginAs(String username, String password) {
        log.info("Logging in as a user: {}", username);
        homePage.clickLoginButton();
        loginPage.enterUsername(username)
            .enterPassword(password)
            .clickLoginButton();
    }
}
