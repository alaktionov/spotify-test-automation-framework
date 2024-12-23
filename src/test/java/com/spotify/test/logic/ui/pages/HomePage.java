package com.spotify.test.logic.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HomePage extends BasePage {

    @FindBy(id = "global-nav-bar")
    private WebElement navigationBar;

    @FindBy(id = "Desktop_LeftSidebar_Id")
    private WebElement sideBar;

    @FindBy(id = "user-widget-avatar")
    private WebElement userAvatar;

    @FindBy(id = "user-widget-avatar")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement loginButton;

    @Step("Click Login button")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Click on User avatar")
    public void clickUserAvatar() {
        wait.until(ExpectedConditions.elementToBeClickable(userAvatar)).click();
    }

    public boolean isNavigationBarDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(navigationBar)).isDisplayed();
    }

    public boolean isSideBarDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(sideBar)).isDisplayed();
    }

    public boolean isUserAvatarDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userAvatar)).isDisplayed();
    }

    public boolean isLogoutButtonDisplayedInUserWidget() {
        return wait.until(ExpectedConditions.visibilityOf(logoutButton)).isDisplayed();
    }
}
