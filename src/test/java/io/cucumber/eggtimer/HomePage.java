package io.cucumber.eggtimer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get("https://e.ggtimer.com/");
    }
    public void enterTime(int seconds, String unit) {
        driver.findElement(By.id("EggTimer-start-time-input-text")).sendKeys(seconds +" "+unit);
    }
    public void clickStart() {
        driver.findElement(By.xpath("//button[text() = \"Start\"]")).click();
    }
    public String timeExpiredMessage(int value, String timeUnit) {
        if (timeUnit.equals("seconds"))
        {
            sleep(value * 1000);
        }
        else if (timeUnit.equals("minutes"))
        {
            sleep(value * 60000);
        }
        String timeExpired;

        Alert alert = driver.switchTo().alert();
        timeExpired = alert.getText();
        alert.accept();
        //timeExpired = driver.findElement(By.xpath("//p/span")).getText();
        return timeExpired;
    }

    public boolean checkTimerBegun() {
        boolean timerPresent;
        int present = driver.findElements(By.className("ClassicTimer-time")).size();
        if (present > 0) {
            timerPresent = true;
        } else {
            timerPresent = false;

        }
        return timerPresent;
    }

    public void clickMinutes(int minutes) {
        driver.findElement(By.linkText("/"+minutes+" minutes")).click();

    }

    public void clickHelpAndSettings() {
        driver.findElement(By.xpath("//button[text() = \"Help and Settings\"]")).click();
    }

    public boolean checkHelpAvailability() {
        boolean helpPresent;
        int present = driver.findElements(By.xpath("//div[@class=\"EggTimer-settings-and-help-content\"]")).size();
        if (present > 0) {
            helpPresent = true;
        } else {
            helpPresent = false;
        }
        return helpPresent;

    }


    public void enterInvalidtime(String word) {
        driver.findElement(By.id("EggTimer-start-time-input-text")).sendKeys(word);
    }

    public boolean startButtonEnabled() {
        return driver.findElement(By.xpath("//button[text() = \"Start\"]")).isEnabled();
    }

    public boolean checkSampleTimerAvailability() {

        boolean linkPresent = false;
        List<String> sampleTimer = Arrays.asList("/5 minutes", "/10 minutes", "/15 minutes","/Pomodoro", "/Tabata", "/Morning" );
        for (String element : sampleTimer)
        {
            int present = driver.findElements(By.linkText(element)).size();
            if (present > 0) {
                linkPresent = true;
            } else {
                linkPresent = false;
                break;
            }
        }

        return linkPresent;
    }
}
