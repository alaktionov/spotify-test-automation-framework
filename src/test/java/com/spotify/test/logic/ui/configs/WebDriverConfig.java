package com.spotify.test.logic.ui.configs;

import java.time.Duration;

import com.spotify.test.logic.ui.pages.HomePage;
import com.spotify.test.logic.ui.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

    @Bean
    public static WebDriver webDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        WebDriver driver;
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    public LoginPage loginPage(WebDriver webDriver) {
        return PageFactory.initElements(webDriver, LoginPage.class);
    }

    @Bean
    public HomePage homePage(WebDriver webDriver) {
        return PageFactory.initElements(webDriver, HomePage.class);
    }

}
