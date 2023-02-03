package io.cucumber.eggtimer;

import org.openqa.selenium.WebDriver;

public class Pages extends BasePage {

    public HomePage homePage;

    public Pages(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }
}
