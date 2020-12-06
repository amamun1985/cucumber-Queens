package stepDefinition_cucumber;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PositiveNegativeSteps {
    private static Logger LOGGER = LogManager.getLogger(PositiveNegativeSteps.class);
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By LogOut = By.id("logout");
    private static final By InvalidPassWord = By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");
    WebDriver driver=Hooks.driver;

    @Given("^a user is on the login page$")
    public void navigateToLoginPage() {
        ActOn.browser(driver).openBrowser("https://example.testproject.io/web/");
        LOGGER.info("User is in the login page");
    }

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
        ActOn.element(driver, FullName).setValue(username);
        ActOn.element(driver, Password).setValue(password);
        LOGGER.info("User has enter valid credentials");
    }

    @And("^click on login button$")
    public void clickOnLoginButton() {
        ActOn.element(driver, Login).click();
        LOGGER.info("User enter on login button");
    }

    @Then("^user is navigated to the home page$")
    public void validateUserLoggedSuccessfully() {
        boolean logOutDisplayed = driver.findElement(LogOut).isDisplayed();
        Assert.assertTrue("logout button is not displayed", logOutDisplayed);
        LOGGER.info("User is in the home page");
    }
    @Then("^user is failed to login$")
    public  void validateUserFailedToLogIN(){
        boolean inValidPassword=driver.findElement(InvalidPassWord).isDisplayed();
        Assert.assertTrue("invalid password is displayes",inValidPassword);
        LOGGER.info("User still in log in page");
    }
}
