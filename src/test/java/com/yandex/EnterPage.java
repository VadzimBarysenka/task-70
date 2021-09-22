package com.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterPage {
    private final WebDriver driver;
    private static final String URL = "https://mail.yandex.com/";

    @FindBy(xpath = "//a[contains(@class, \"HeadBanner-Button-Enter\")]")
    private WebElement enterButton;

    public EnterPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
        this.driver = WebDriverSingleton.getInstance().getDriver();
        this.driver.get(URL);
    }

    public LoginPage enterToLoginPage() {
        enterButton.click();
        return new LoginPage();
    }
}