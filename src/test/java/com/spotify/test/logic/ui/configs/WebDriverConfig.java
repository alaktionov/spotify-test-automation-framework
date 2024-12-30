package com.spotify.test.logic.ui.configs;

import java.time.Duration;

import com.spotify.test.logic.ui.pages.HomePage;
import com.spotify.test.logic.ui.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

    @Bean
    @Scope("prototype")
    public WebDriver webDriver() {
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofMinutes(10));
    }

    @Bean
    public LoginPage loginPage(WebDriver driver) {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @Bean
    public HomePage homePage(WebDriver driver) {
        return PageFactory.initElements(driver, HomePage.class);
    }

}
