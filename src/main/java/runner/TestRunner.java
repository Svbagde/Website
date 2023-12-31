package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/com/amazon/features",
	    glue = "com.amazon.stepdefinitions",
	    tags = "@smoke", 
	    plugin = {"pretty", "html:target/cucumber-reports"}
	)
public class TestRunner extends AbstractTestNGCucumberTests {

}
