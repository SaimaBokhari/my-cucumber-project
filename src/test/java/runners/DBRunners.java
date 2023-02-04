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
                "rerun:target/failedRerun.txt",
        },
        monochrome = false,     // makes the console grey

        features = "./src/test/resources/features/jdbc",   // Path of Features folder
        glue = {"stepdefinitions"},
        dryRun = false,
        tags = "@db_read"
)
public class DBRunners {

}

