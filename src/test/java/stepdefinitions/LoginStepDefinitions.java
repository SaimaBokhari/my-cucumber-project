package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @When("user enters customer email and customer password")
    public void user_enters_customer_email_and_customer_password(DataTable dataTable) {
        // 1. Get data as List of String
       /*
       List<String> customerData = dataTable.row(0);  // returns the  first row (header) coz row index starts at zero
        // System.out.println("customerData = " + customerData);
        System.out.println(customerData.get(0));   // inside the list customerData, index (0) is the first value
        System.out.println(customerData.get(1));   // inside the list customerData, index (1) is the second value

        String email = dataTable.row(1).get(0);
        System.out.println("email = " + email);

        String password = dataTable.row(1).get(1);
        System.out.println("password = " + password);

        loginPage.userName.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.logInButton.click();
*/

        // 2. Get data as a List of Map ==> List<Map<String, String>>

        List<Map<String, String>> customerData = dataTable.asMaps(String.class, String.class);
        System.out.println("customerData = " + customerData);  // [{username=jack@gmail.com, password=12345}]

        for (Map<String, String> w : customerData){
            ReusableMethods.waitFor(1);
            loginPage.userName.sendKeys(w.get("username"));
            ReusableMethods.waitFor(1);
            loginPage.password.sendKeys(w.get("password"));
            ReusableMethods.waitFor(1);
            loginPage.logInButton.click();
        }
    }


    @Then("verify application login is successful")
    public void verify_application_login_is_successful() {
        ReusableMethods.waitFor(1);
        assertTrue(homePage.userId.isDisplayed());

    }

    @Then("verify the next page url contains login keyword")
    public void verifyTheNextPageUrlContainsLoginKeyword() {
        ReusableMethods.waitFor(3);
        assertTrue(false);  // to make the test fail and see the screenshot in html report
    }
}
