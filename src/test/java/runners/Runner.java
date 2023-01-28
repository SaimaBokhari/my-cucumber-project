package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",     // makes the console printing green
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        monochrome = false,     // makes the console grey

        features = "./src/test/resources/features",   // Path of Features folder
        glue = {"stepdefinitions" , "hooks"},
        dryRun = false,
        tags = "@MedunnaRoom"
)
public class Runner {

}


/*
When you run Runner, it will go to feature file, and start execution from top to bottom.
If there is any step matching, Java will find that matching 'stepdefinition', and it will be executed.
If there is no match then Cucumber will generate template for us in the console.
 */

/*
features = "./src/test/resources/features",   // Path of Features folder
glue = "stepdefinitions" ,  // PATH OF STEP DEFINITIONS folder or just the name coz all this package is at the same level as runners package
dryRun = false    //If true that means RUN DRY => give me the missing stepdefinition without running all the previous steps OR the whole test case.
                  // To run the test case, we have to make dryRun=false (default) otherwise it won't run the test case.


  Cucumber HTML Reports

We need to add reports plug in the Runner to get the reports.
We can get html, json, or junit reports
For testers, html reports are the most important  (open in browsers)
We also add Maven reporting plugins for reports
Change the name before running, otherwise it will be overrun e.g. "html:target/default-cucumber-reports2.html", .. add name/number after "cucumber-reports"

DATA TABLES
> are used to pass test data (multiple data)
> Data Tables are similar to scenario_outline but a bit more difficult as it requires more Java codes
> DIFFERENCES
> No "Examples" keyword in DATA TABLES
> DATA TABLES can be used at any step in the code, but Examples keyword is ONLY used at the end of the code
> In DATA TABLES, we use "Scenario" ONLY.
> DATA TABLES return tables object in the method, so we have to use Collections to use them in stepdefinitions
> Scenario outline returns String in the method, so easier to get and use.
> DATA TABLES are not as popular as Scenario Outline

HOOKS
> specific for Cucumber .. important one
> it is a class that runs Before and After each scenario
> import from Cucumber
> used to generate reports with screenshots
> AfterMethod is very helpful to capture screenshots when Scenario fails
> screenshot will be attached in html file

 */