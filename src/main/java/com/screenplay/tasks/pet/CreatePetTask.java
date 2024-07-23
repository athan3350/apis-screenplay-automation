package com.screenplay.tasks.pet;


import com.screenplay.constants.GeneralConstants;
import com.screenplay.models.general.RequestStructureModel;
import com.screenplay.models.pet.CreatePetModel;
import com.screenplay.questions.pet.PetCreateRequestQuestion;
import com.screenplay.tasks.general.ToDoPostTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Map;

import static com.screenplay.constants.PathConstants.PET_PATH;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class CreatePetTask implements Task {


    private final List<Map<String, String>> dataRequest;
    RequestStructureModel requestStructureModel;

    public CreatePetTask(List<Map<String, String>> dataRequest) {
        this.dataRequest = dataRequest;
    }

    public static CreatePetTask now(List<Map<String, String>> dataRequest) {
        return instrumented(CreatePetTask.class, dataRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        CreatePetModel jsonBodyRequest = actor.asksFor(PetCreateRequestQuestion.withData(dataRequest));

        requestStructureModel = RequestStructureModel.builder()
                .basePath(PET_PATH)
                .jsonBody(jsonBodyRequest)
                .contentType(GeneralConstants.CONTENT_TYPE_JSON)
                .build();

        actor.attemptsTo(ToDoPostTask.doPost(requestStructureModel));

    }
}
