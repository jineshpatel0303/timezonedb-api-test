package com.example.testsuits;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.example.stepdefinitions"},
        features = {"src/test/resources/features/timezone.feature"}
)
public class TimeZoneSuite {
}
