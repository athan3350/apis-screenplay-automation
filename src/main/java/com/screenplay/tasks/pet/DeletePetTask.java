package com.screenplay.tasks.pet;


import com.screenplay.constants.GeneralConstants;
import com.screenplay.models.general.RequestStructureModel;
import com.screenplay.models.pet.CreatePetModel;
import com.screenplay.questions.pet.PetCreateRequestQuestion;
import com.screenplay.tasks.general.ToDoDeleteTask;
import com.screenplay.tasks.general.ToDoPostTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Map;

import static com.screenplay.constants.PathConstants.PET_PATH;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DeletePetTask implements Task {


    private final List<Map<String, String>> dataRequest;
    RequestStructureModel requestStructureModel;

    public DeletePetTask(List<Map<String, String>> dataRequest) {
        this.dataRequest = dataRequest;
    }

    public static DeletePetTask now(List<Map<String, String>> dataRequest) {
        return instrumented(DeletePetTask.class, dataRequest);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String path = String.format("%s/%s", PET_PATH, dataRequest.get(0).get("id"));

        requestStructureModel = RequestStructureModel.builder()
                .basePath(path)
                .contentType(GeneralConstants.CONTENT_TYPE_JSON)
                .build();

        actor.attemptsTo(ToDoDeleteTask.doDelete(requestStructureModel));

    }
}
