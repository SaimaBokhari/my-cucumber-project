package stepdefinitions;

import io.cucumber.java.en.When;
import utilities.Driver;

public class RegExStepDefinitions {
//    @When("I open {string} page")
//    public void i_open_page(String string) {
//        Driver.getDriver().get(string);
//    }


//    {string} --->>> "([^"]*)"
//    With regex, we can now make the feature file
//    a little more flexible
//    in this example,our data is parametrized
//    ALSO TEH STEP CAN START WITH I OR i
    @When("^[I|i]? open \"([^\"]*)\" page")
    public void i_open_page(String string) {
        Driver.getDriver().get(string);
    }



}