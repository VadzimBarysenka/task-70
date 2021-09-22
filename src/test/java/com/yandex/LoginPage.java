package com.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "passp-field-login")
    private WebElement userNameField;

    @FindBy(id = "passp-field-passwd")
    private WebElement userPasswordField;

    @FindBy(id = "passp:sign-in")
    private WebElement loginButton;

    public LoginPage () {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
        this.driver = WebDriverSingleton.getInstance().getDriver();
    }

    public MailPage loginToMail(String name, String password) {
        userNameField.sendKeys(name);
        loginButton.click();
        userPasswordField.sendKeys(password);
        loginButton.click();
        return new MailPage();
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }
}