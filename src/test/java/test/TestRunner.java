package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue={"stepDefinition_cucumber"},
        plugin = {"pretty","summary","json:target/Cucumber.json"},
        publish = true
)

public class TestRunner {

}
