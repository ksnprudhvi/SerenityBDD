package com.assignment.cucumber;

import org.junit.runner.RunWith;

import com.assignment.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")
public class TestRunner extends TestBase {

}
