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
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        monochrome = false,     // makes the console grey

        features = "@target/failedRerun.txt",   // Path of the folder where failed scenarios are
        glue = {"stepdefinitions" , "hooks"},
        dryRun = false
)

public class FailedScenarioRunner {

}
/*
This runner class is used to run only failedRerun.txt file
That file only has failed scenarios if any scenario fails
That file will be empty if no scenario fails
We do not use tag or path of the features folder
This failedRerun.txt file doesn't keep history. If you fix the code, re-run this
file, if the test passes, this file will come back empty.

 */
