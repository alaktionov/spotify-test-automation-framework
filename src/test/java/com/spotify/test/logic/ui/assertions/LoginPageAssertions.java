package com.spotify.test.logic.ui.assertions;

import com.spotify.test.logic.ui.pages.LoginPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Component
public class LoginPageAssertions {

    private static final String LOGIN_PAGE_TITLE = "Login - Spotify";

    @Autowired
    private LoginPage loginPage;

    @Step("Verify Login Page title")
    public LoginPageAssertions verifyLoginPageTitle() {
        assertTrue(loginPage.isPageTitleCorrect(LOGIN_PAGE_TITLE), "Login Page title is incorrect");
        return this;
    }

    @Step("Verify Google login is present")
    public LoginPageAssertions verifyGoogleLoginIsPresent() {
        assertTrue(loginPage.isGoogleLoginButtonDisplayed(), "Google login should be present");
        return this;
    }

    @Step("Verify Facebook login is present")
    public LoginPageAssertions verifyFacebookLoginIsPresent() {
        assertTrue(loginPage.isFacebookLoginButtonDisplayed(), "Facebook login should be present");
        return this;
    }

    @Step("Verify Google login is present")
    public LoginPageAssertions verifyAppleLoginIsPresent() {
        assertTrue(loginPage.isAppleLoginButtonDisplayed(), "Apple login should be present");
        return this;
    }

    @Step("Verify validation error is present")
    public LoginPageAssertions verifyValidationErrorIsPresent() {
        assertTrue(loginPage.isErrorBannerDisplayed(), "Validation error should be present");
        return this;
    }

}
