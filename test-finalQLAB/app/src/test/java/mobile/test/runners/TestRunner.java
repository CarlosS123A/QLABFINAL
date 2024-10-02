package mobile.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.steps",
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}