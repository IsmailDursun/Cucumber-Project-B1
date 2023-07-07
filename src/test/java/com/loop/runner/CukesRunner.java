package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-reports.html",
                "json:target/json-reports/json-report",
                "rerun:target/rerun.txt",
                "pretty"


        },
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions",
        dryRun = false,
        tags = "@wip",
        monochrome = true
        // publish = true
)
public class CukesRunner {

}
