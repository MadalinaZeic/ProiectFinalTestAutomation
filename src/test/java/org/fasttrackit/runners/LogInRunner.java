package org.fasttrackit.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/json-reports/logIn.json"},
        glue = {"org.fasttrackit"},
        features = {"src/test/resources/features/log-in.feature"}
)
@RunWith(Cucumber.class)
public class LogInRunner {
}
