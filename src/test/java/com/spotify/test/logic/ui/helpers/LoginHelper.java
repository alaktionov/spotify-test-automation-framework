package com.spotify.test.logic.ui.helpers;

import com.spotify.test.logic.ui.pages.HomePage;
import com.spotify.test.logic.ui.pages.LoginPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHelper extends BaseHelper {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Step("Login as a user {username}")
    public void loginAs(String username, String password) {
        homePage.clickLoginButton();
        loginPage.enterUsername(username).enterPassword(password).clickLoginButton();
    }

    @Step("Login as an admin user")
    public void loginAsAdmin() {
        homePage.clickLoginButton();
        loginPage.enterUsername(appConfig.getUsername()).enterPassword(appConfig.getPassword()).clickLoginButton();
    }
}
