package com.screenplay.stepdefinitions.general;

import com.screenplay.tasks.pet.CreatePetTask;
import com.screenplay.tasks.pet.ValidatePetCreationResponseTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

public class PetSteps {

    @When("creates a pet")
    public void createPet(List<Map<String, String>> structureData) {
        OnStage.withCurrentActor(
                CreatePetTask.now(structureData)
        );
    }

    @And("He\\She will verify that the information from the pet creation is correct")
    public void heSheWillVerifyThatTheInformationFromThePetCreationIsCorrect(List<Map<String, String>> structureData) {
        OnStage.withCurrentActor(
                ValidatePetCreationResponseTask.validate(structureData)
        );
    }
}

