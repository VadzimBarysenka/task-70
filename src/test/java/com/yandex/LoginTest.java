package com.yandex;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private WebDriver driver;
    private static final String SCREEN_NAME = RandomStringUtils.randomAlphabetic(10);
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";

    @BeforeEach
    public void setup() {
        driver = WebDriverSingleton.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanup() {
        driver.close();
    }

    @Test
    public void login() {
        MailPage mailPage = new EnterPage()
                .enterToLoginPage()
                .loginToMail(USER_NAME, USER_PASSWORD);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("target\\screenshots\\" + SCREEN_NAME + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(USER_NAME, mailPage.getUserName());
    }
}
