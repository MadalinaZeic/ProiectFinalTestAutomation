package org.fasttrackit.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/json-reports/register.json"},
        glue = {"org.fasttrackit"},
        features = {"src/test/resources/features/register-page.feature"}
)
@RunWith(Cucumber.class)
public class RegisterRunner {
}
