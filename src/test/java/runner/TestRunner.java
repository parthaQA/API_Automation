package runner;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = "src/main/java/features",
        glue = {"stepsDefinitions"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json",
        "rerun:target/failedScenario.txt"}
)


public class TestRunner extends AbstractTestNGCucumberTests {



}
