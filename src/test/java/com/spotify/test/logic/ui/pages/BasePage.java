package com.spotify.test.logic.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    public String getTitle() {
        return driver.getTitle();
    }
}