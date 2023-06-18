package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin = {
//                "pretty",
//                "html:target/cucumber-report.html",
//                "rerun:target/rerun.txt",
//                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
//        },
        features = "src/test/resources/features" ,
        glue = "com/loop/step_definitions",
//        dryRun = false,
        tags = "@smoke" // it will run all @smoke tags scenarios
//        monochrome = true,
//        publish = true
)
public class Runner {

}
