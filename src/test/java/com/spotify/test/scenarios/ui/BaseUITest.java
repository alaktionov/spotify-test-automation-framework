package com.spotify.test.scenarios.ui;

import com.spotify.test.BaseTest;
import com.spotify.test.logic.ui.helpers.LoginHelper;
import com.spotify.test.logic.ui.helpers.NavigationHelper;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseUITest extends BaseTest {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected NavigationHelper navigationHelper;

    @Autowired
    protected LoginHelper loginHelper;

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
