package com.cucumber.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 tags = "@FirstTest",
                 glue = {"com/cucumber/StepDefinitions"},monochrome = true)
public class loginRunner{
}
