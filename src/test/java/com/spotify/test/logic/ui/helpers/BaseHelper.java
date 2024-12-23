package com.spotify.test.logic.ui.helpers;

import com.spotify.test.logic.common.AppConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseHelper {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected AppConfig appConfig;

}
