package com.spotify.test.logic.ui.pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement loginButton;

    @Step("Click Login button")
    public void clickLoginButton() {
        loginButton.click();
    }
}
