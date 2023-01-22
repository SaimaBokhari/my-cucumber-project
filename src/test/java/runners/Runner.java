package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",   // Path of Features folder
        glue = "stepdefinitions" ,        // PATH OF STEP DEFINITIONS folder or just the name coz all this package is at the same level as runners package
        dryRun = false,
        tags = "@parametrizing1"
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
 */