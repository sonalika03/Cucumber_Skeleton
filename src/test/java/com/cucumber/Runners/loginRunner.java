package com.cucumber.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 tags = "@FirstTest",
                 glue = {"com/cucumber/StepDefinitions"},monochrome = true, plugin = {"pretty", "pretty:target/cucumber-report/Reports/pretty.txt",
                        "html:target/cucumber-report/Reports/report.html",
                       "json:target/cucumber-report/Reports/report.json",
                        "junit:target/cucumber-report/Reports/junitreport.xml",
                        "testng:target/cucumber-report/Reports/testngreport.xml"})
public class loginRunner{
}
