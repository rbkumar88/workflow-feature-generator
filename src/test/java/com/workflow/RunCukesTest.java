package com.workflow;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        glue = {"com.consol.citrus.cucumber.step.runner.http","com.consol.citrus.cucumber.step.runner.core"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        tags = {"~@ignore"})
//	dryRun = true)
public class RunCukesTest {

}
