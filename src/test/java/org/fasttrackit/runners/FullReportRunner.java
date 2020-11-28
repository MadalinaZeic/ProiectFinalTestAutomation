package org.fasttrackit.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/json-reports/fullReport.json"},
        glue = {"org.fasttrackit"},
        features = {
                "src/test/resources/features/add-to-cart.feature",
                "src/test/resources/features/checkout.feature",
                "src/test/resources/features/home-page.feature",
                "src/test/resources/features/log-in.feature",
                "src/test/resources/features/register-page.feature",
                "src/test/resources/features/search-products.feature"
        }
)

@RunWith(Cucumber.class)
public class FullReportRunner {
}