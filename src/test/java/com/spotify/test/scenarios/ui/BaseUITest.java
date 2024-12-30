package com.spotify.test.scenarios.ui;

import com.spotify.test.BaseTest;
import com.spotify.test.logic.ui.helpers.LoginHelper;
import com.spotify.test.logic.ui.helpers.NavigationHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseUITest extends BaseTest {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected NavigationHelper navigationHelper;

    @Autowired
    protected LoginHelper loginHelper;

    @BeforeEach
    public void setup() {
        navigationHelper.navigateToHomePage();
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
