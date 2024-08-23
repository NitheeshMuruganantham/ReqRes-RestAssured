package cucumber;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "\\src\\test\\java\\cucumber\\reqRes.feature", glue= "cucumberStepDef" )
public class runner {

}
