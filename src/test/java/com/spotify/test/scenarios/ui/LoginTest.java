package com.spotify.test.scenarios.ui;

import com.spotify.test.logic.ui.assertions.HomePageAssertions;
import com.spotify.test.logic.ui.assertions.LoginPageAssertions;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Epic("UI - Test scenarios for login functionality")
public class LoginTest extends BaseUITest {

    @Autowired
    private HomePageAssertions homePageAssertions;

    @Autowired
    private LoginPageAssertions loginPageAssertions;

    @Disabled
    @Test
    @Story("Login as a valid user")
    public void testLoginValidUser() {
        loginHelper.loginAs(appConfig.getUsername(), appConfig.getPassword());
        homePageAssertions.verifyHomePageTitle()
            .verifyNavigationBarIsPresent()
            .verifySideBarIsPresent()
            .verifyUserAvatarIsPresent()
            .verifyLogoutButtonIsPresentInUserWidget();
    }

    @Test
    @Story("Login as an invalid user")
    public void testLoginInvalidUser() {
        loginHelper.loginAs("test", "test");
        loginPageAssertions.verifyLoginPageTitle()
            .verifyValidationErrorIsPresent()
            .verifyGoogleLoginIsPresent()
            .verifyFacebookLoginIsPresent()
            .verifyAppleLoginIsPresent();
    }

}
