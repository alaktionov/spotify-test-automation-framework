package com.spotify.test.logic.ui.assertions;

import com.spotify.test.logic.ui.pages.HomePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Component
public class HomePageAssertions {

    private static final String HOME_PAGE_TITLE = "Spotify - Web Player: Music for everyone";

    @Autowired
    private HomePage homePage;

    @Step("Verify Home Page title")
    public HomePageAssertions verifyHomePageTitle() {
        assertTrue(homePage.isPageTitleCorrect(HOME_PAGE_TITLE), "Home Page title is incorrect");
        return this;
    }

    @Step("Verify Navigation bar is present")
    public HomePageAssertions verifyNavigationBarIsPresent() {
        assertTrue(homePage.isNavigationBarDisplayed(), "Navigation bar is expected to be displayed");
        return this;
    }

    @Step("Verify Side bar is present")
    public HomePageAssertions verifySideBarIsPresent() {
        assertTrue(homePage.isSideBarDisplayed(), "Navigation bar is expected to be displayed");
        return this;
    }

    @Step("Verify User avatar is present")
    public HomePageAssertions verifyUserAvatarIsPresent() {
        assertTrue(homePage.isUserAvatarDisplayed(), "User avatar is expected to be displayed");
        return this;
    }

    @Step("Verify Logout button is present in User Widget")
    public HomePageAssertions verifyLogoutButtonIsPresentInUserWidget() {
        assertTrue(homePage.isLogoutButtonDisplayedInUserWidget(), "Logout is expected to be displayed in User Widget");
        return this;
    }

}
