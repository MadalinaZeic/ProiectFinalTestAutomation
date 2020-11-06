package org.fasttrackit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take screenshot on test failed
        if (scenario.isFailed()) {
            scenario.embed( ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES),"image/png");
        }

        DriverFactory.getDriver().quit();
    }
}

