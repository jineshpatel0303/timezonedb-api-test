package com.example.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.SystemEnvironmentVariables;


public class EnvironmentConfiguration {
    private static final EnvironmentSpecificConfiguration environmentSpecificConfiguration = EnvironmentSpecificConfiguration.from(SystemEnvironmentVariables.createEnvironmentVariables());

    public static String getProperty(String propertyName) {
        return environmentSpecificConfiguration.getProperty(propertyName);
    }
}
