
package com.screenplay.utilities;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class TestEnvironments {

    private final EnvironmentVariables environmentVariables;

    public TestEnvironments(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getDataConfiguration(String path) {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
            .getProperty("environments."+System.getenv("environment")+"."+path);
    }

}
