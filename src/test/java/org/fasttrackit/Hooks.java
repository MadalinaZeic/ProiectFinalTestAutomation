package org.fasttrackit;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown() {
//        DriverFactory.getDriver().quit();
    }
}

