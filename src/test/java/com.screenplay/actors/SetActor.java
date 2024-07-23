package com.screenplay.actors;

import com.screenplay.constants.KeysToRememberConstants;
import com.screenplay.utilities.TestEnvironments;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.screenplay.constants.PathConstants.REST_BASE_URL;

public class SetActor extends Cast {
    private final TestEnvironments testEnvironments;
    Actor actor;

    public SetActor(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {

        actor = super.actorNamed(actorName, CallAnApi.at(testEnvironments.getDataConfiguration(REST_BASE_URL)));
        actor.remember(KeysToRememberConstants.BASE_URI_ACTOR, testEnvironments.getDataConfiguration(REST_BASE_URL));

        return actor;
    }
}


