package io.cucumber.eggtimer;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class StepDefinitions {

    Pages pages;
    WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();

        //To disable the notifications in Google Chrome browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        pages = new Pages(driver);
    }
    @After
    public void after(){
        driver.quit();
    }

    @Given("I navigate to eggtimer home page")
    public void i_navigate_to_eggtimer_home_page() {
        pages.homePage.navigate();
    }

    @And("enter {int} seconds")
    public void enterATimeValueInt(int seconds) {
        pages.homePage.enterTime(seconds,"seconds");
    }

    @And("user clicks the start button")
    public void userClicksTheStartButton() {
        pages.homePage.clickStart();
   }

    @Then("countdown timer should start")
    public void countdownTimerShouldStart() {
       Assertions.assertTrue(pages.homePage.checkTimerBegun());
    }

    @And("time expired alert is shown after {int} seconds")
    public void timeExpiredMessageIsShownAfterTimeSeconds(int seconds) {

        String message = "Time Expired!";
        Assertions.assertEquals(message,pages.homePage.timeExpiredMessage(seconds,"seconds"));
    }

    @And("click the {int} minutes button")
    public void clickTheTimeMinutesButton(int minutes) {
        pages.homePage.clickMinutes(minutes);

    }

    @And("time expired alert is shown after {int} minutes")
    public void timeExpiredAlertIsShownAfterTimeMinutes(int minutes) {
        String message = "Time Expired!";
        Assertions.assertEquals(message,pages.homePage.timeExpiredMessage(minutes,"minutes"));

    }

    @When("click help and settings button")
    public void clickHelpAndSettingsButton() {
        pages.homePage.clickHelpAndSettings();
    }

    @Then("help and settings window should open")
    public void helpAndSettingsWindowShouldOpen() {
        Assertions.assertTrue(pages.homePage.checkHelpAvailability());
    }

    @And("enter invalid time {word}")
    public void enterInvalidTimeTime(String word) {
        pages.homePage.enterInvalidtime(word);
    }

    @Then("countdown timer should not start")
    public void countdownTimerShouldNotStart() {
        Assertions.assertFalse(pages.homePage.checkTimerBegun());
    }

    @Then("all the sample timers should be available")
    public void allTheSampleTimersShouldBeAvailable() {
        Assertions.assertTrue(pages.homePage.checkSampleTimerAvailability());
    }
}
