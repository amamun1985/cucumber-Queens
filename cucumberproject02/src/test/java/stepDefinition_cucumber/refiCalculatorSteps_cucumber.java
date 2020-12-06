package stepDefinition_cucumber;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectModel.NavigationBar;
import pageObjectModel.Refi_Calculate;

public class refiCalculatorSteps_cucumber {

    private static Logger LOGGER= LogManager.getLogger(refiCalculatorSteps_cucumber.class);
    WebDriver driver=Hooks.driver;
    @Given("^a user is on the mortgage calculator homepage$")
    public void homePage(){
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
        LOGGER.info("User is in the home page");
    }
    @When("^mouse hover on Refinence and click on Refi Calculator$")
    public void mouseHover(){
    new NavigationBar(driver)
            .mouseHover()
            .clickLink();
        LOGGER.info("select refi Calculator");
    }
    @And("^user entering \"(.+?)\",\"(.+?)\",\"(.+?)\" and \"(.+?)\" click on calculate button$")
    public void enterData(String homeValue,String downPayment,String loanTerm,String Interests){
        new Refi_Calculate(driver)
                .homeValue(homeValue)
                .downPayment(downPayment)
                .loanLenght(loanTerm)
                .interestValue(Interests)
                .enterCalculateButton();
        LOGGER.info("User enter all credential");
    }
   @Then("^validate the monthly payment \"(.+?)\" and return to homepage$")
    public void validatePayment(String monthlyPayment){
        new Refi_Calculate(driver)
                .priceVal(monthlyPayment)
                .clickLogo();
        LOGGER.info("This is the validation of monthly payment");
   }

}
