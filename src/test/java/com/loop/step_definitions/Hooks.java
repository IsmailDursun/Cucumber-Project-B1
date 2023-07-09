package com.loop.step_definitions;

import com.loop.utilities.*;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;

public class Hooks {
    private static final Logger LOG = LogManager.getLogger();

    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("...........START AUTOMATION.......LOOP ACADEMY.....");
    }
    @After
    public void tearDown(Scenario scenario){

        BrowserUtils.justWait(2);
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        LOG.info("...........END AUTOMATION.......LOOP ACADEMY.....");

    }
    @AfterStep
    public void takeScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}