package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();

    @Given("user is on the google home page")
    public void user_is_on_the_google_home_page() {
        // Write Java code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        // to handle any popup on google if it appears
//        try{
//            googlePage.popUpAccept.click();  // accept pop up if visible. Catch the error abd continue if not visible
//        }catch (Exception e){
//
//        }

    }

    @When("user search for iPhone")
    public void user_search_for_i_phone() {
        // Write code here that turns the phrase above into concrete actions
        googlePage.searchBox.sendKeys("iPhone" + Keys.ENTER);
    }
    @Then("verify page title contains iPhone")
    public void verify_page_title_contains_i_phone() {
        assertTrue(Driver.getDriver().getTitle().contains("iPhone"));
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @When("user search for Teapot")
    public void user_search_for_teapot() {
        googlePage.searchBox.sendKeys("Teapot" + Keys.ENTER);
    }
    @Then("verify page title contains Teapot")
    public void verify_page_title_contains_teapot() {
        assertTrue(Driver.getDriver().getTitle().contains("Teapot"));
    }

    @When("user search for {string} on google")
    public void user_search_for_on_google(String string) {
        googlePage.searchBox.sendKeys(string+Keys.ENTER);
    }

    @Then("verify page title contains {string}")
    public void verify_page_title_contains(String string) {
        assertTrue(Driver.getDriver().getTitle().contains(string));
    }






}
