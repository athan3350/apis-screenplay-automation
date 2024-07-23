package com.screenplay.tasks.pet;

import com.screenplay.models.pet.CreatePetModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ValidatePetCreationResponseTask implements Task {
    private final List<Map<String, String>> dataRequest;
    Map<String, String> data = new HashMap<>();

    public ValidatePetCreationResponseTask(List<Map<String, String>> dataRequest) {
        this.dataRequest = dataRequest;
    }

    public static ValidatePetCreationResponseTask validate(List<Map<String, String>> dataRequest) {
        return instrumented(ValidatePetCreationResponseTask.class, dataRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        data.putAll(dataRequest.get(0));
        CreatePetModel dataReceived = actor.asksFor(LastResponse.received()).as(CreatePetModel.class);
        actor.attemptsTo(
                Ensure.that(dataReceived.getId()).isEqualTo(Integer.valueOf(data.get("id"))),
                Ensure.that(dataReceived.getName()).isEqualTo(data.get("name")),
                Ensure.that(dataReceived.getTags().get(0).getId()).isEqualTo(Integer.valueOf(data.get("tags.id"))),
                Ensure.that(dataReceived.getTags().get(0).getName()).isEqualTo(data.get("name")),
                Ensure.that(dataReceived.getPhotoUrls()).containsAnyOf(data.get("photoUrls")),
                Ensure.that(dataReceived.getCategory().getId()).isEqualTo(Integer.valueOf(data.get("category.id"))),
                Ensure.that(dataReceived.getCategory().getName()).isEqualTo(data.get("category.name"))
        );

    }
}
