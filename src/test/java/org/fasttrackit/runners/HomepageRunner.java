package org.fasttrackit.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/json-reports/homePage.json"},
        glue = {"org.fasttrackit"},
        features = {"src/test/resources/features/home-page.feature"}
)
@RunWith(Cucumber.class)
public class HomepageRunner {
}
