package com.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private final WebDriver driver;
    private final By searchField = By.className("search-bubble-list__bubble-wrap");

    @FindBy(xpath = "//a[contains(@class, \"legouser__current-account\")]/span[@class=\"user-account__name\"]")
    private WebElement userName;

    @FindBy(xpath = "//a[@aria-label=\"Log out\"]")
    private WebElement logOut;

    public MailPage() {
        PageFactory.initElements(WebDriverSingleton.getInstance().getDriver(), this);
        this.driver = WebDriverSingleton.getInstance().getDriver();
        new WebDriverWait(this.driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchField));
    }

    public String getUserName() {
        return userName.getText();
    }

    public LoginPage logout() {
        userName.click();
        logOut.click();
        return new LoginPage();
    }
}