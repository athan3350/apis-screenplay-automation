package com.screenplay.stepdefinitions.general;

import com.screenplay.tasks.general.ValidateEmptyResponseTask;
import com.screenplay.tasks.general.ValidateStructureResponseTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import org.everit.json.schema.ValidationException;

import java.util.List;
import java.util.Map;

public class GeneralSteps {

    @Given("{word} is a pet store user")
    public void initializeActor(String actorName) {
        OnStage.theActorCalled(actorName);
    }

    @Then("Will verify that the request was made successfully")
    public void verifyRequestStructure(List<Map<String, String>> structureData) throws ValidationException {
        OnStage.withCurrentActor(ValidateStructureResponseTask.doValidate(structureData));
    }

    @Then("He\\She will verify that He\\She didn't receive any information")
    public void verifyYourInformationFromRemovedIdentity() {
        OnStage.withCurrentActor(ValidateEmptyResponseTask.doValidate());
    }

}

