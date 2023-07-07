package com.loop.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import com.loop.utilities.*;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    private static final Logger LOG = LogManager.getLogger();
    @Before
    public void setup(){
        Driver.getDriver();
        LOG.info("...........START AUTOMATION.......LOOP ACADEMY......");
    }

    @After
    public void tearDown(Scenario scenario) {
        // only takes a screenshot if the scenario fails
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
           // scenario.embed(screenshot, "image/png");
        }
       Driver.closeDriver();

        LOG.info("...........END AUTOMATION.......LOOP ACADEMY.....");
    }

    @AfterStep
    public void screenShot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

}
