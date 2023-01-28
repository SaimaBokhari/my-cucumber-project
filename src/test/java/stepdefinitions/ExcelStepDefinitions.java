package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ExcelStepDefinitions {
    HomePage homePage;
    LoginPage loginPage;

    ExcelUtils excelUtils;
    List<Map<String, String>> allTestData;  // This will store all data from Excel file


    // Create a login method
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(1);  // Hard wait

        try {
            homePage.homePageLoginButton.click();
        }catch (Exception e){
        }
        // in order to login each user, we need to logout each, one by one, so we include the following steps:
        try{
            ReusableMethods.waitFor(1);
            homePage.userId.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginButton.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){

        }
        ReusableMethods.waitFor(1);
        // We'll send the credentials using Excel file
        // We need to use multiple credentials

    }


    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) throws IOException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = sheet;

        excelUtils = new ExcelUtils(path, sheetName); // instantiate it .. needs 2 parameters as Constructor is parameterised

        // getDataList() returns all Excel data and then we store it in allTestData variable.
        allTestData = excelUtils.getDataList();

//        System.out.println("allTestData = " + allTestData); // List of Map will print the data in random order
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));

        // Using LOOP get the values from the map one by one and send them to the UI

        for (Map<String,String> eachData: allTestData){
            // Takes us to the homepage
            login();  // the method we created above ( before this test)
            loginPage.userName.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);
            loginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(2);
            loginPage.logInButton.click();
            ReusableMethods.waitFor(2);

            // Verify if login is successful (if userId is displayed, then it's successful)
            assertTrue(homePage.userId.isDisplayed());

            // to get screenshot for each data entry, put this method inside the loop, otherwise, it will only get one screenshot
            ReusableMethods.getScreenshot(eachData.get("username"));

        }
    }

/*
Notes:

For DDT, our first choice in Cucumber is Scenario_outline.
But we need to know how to use Excel in Cucumber as well.
It's exactly the same as TestNG, except for @Test annotation, we have @Given annotation in cucumber
 */

    @Then("verify the application login is successful")
    public void verify_the_application_login_is_successful() {

    }
    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshot");

    }

}
