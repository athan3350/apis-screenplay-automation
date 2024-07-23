package com.screenplay.stepdefinitions;

import com.screenplay.actors.SetActor;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {

    private EnvironmentVariables environmentVariables;

    @Before
    public void settingTheStage() {
        OnStage.setTheStage(new SetActor(environmentVariables));
    }

}
