package com.spotify.test.logic.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='google-login']")
    private WebElement googleLoginButton;

    @FindBy(xpath = "//button[@data-testid='facebook-login']")
    private WebElement facebookLoginButton;

    @FindBy(xpath = "//button[@data-testid='apple-login']")
    private WebElement appleLoginButton;

    @FindBy(id = "login-username")
    private WebElement usernameField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@data-encore-id='banner']")
    private WebElement errorBanner;

    @Step("Enter username")
    public LoginPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        return this;
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isGoogleLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(googleLoginButton)).isDisplayed();
    }

    public boolean isFacebookLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(facebookLoginButton)).isDisplayed();
    }

    public boolean isAppleLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(appleLoginButton)).isDisplayed();
    }

    public boolean isErrorBannerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(errorBanner)).isDisplayed();
    }
}
