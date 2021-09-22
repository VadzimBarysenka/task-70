package com.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private final WebDriver driver;
    private static WebDriverSingleton instance;

    private WebDriverSingleton() {
        this.driver = new ChromeDriver();
    }

    public static WebDriverSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }
}