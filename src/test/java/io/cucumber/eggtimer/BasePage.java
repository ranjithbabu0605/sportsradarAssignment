package io.cucumber.eggtimer;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver) { this.driver = driver;}

    public void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

