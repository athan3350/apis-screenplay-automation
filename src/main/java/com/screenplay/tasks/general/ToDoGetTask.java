package com.screenplay.tasks.general;


import com.screenplay.models.general.RequestStructureModel;
import com.screenplay.questions.general.SetRequestStructureQuestion;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ToDoGetTask implements Task {

    private final RequestStructureModel requestStructureModel;

    public ToDoGetTask(RequestStructureModel requestStructureModel) {
        this.requestStructureModel = requestStructureModel;
    }

    public static ToDoGetTask doGet(RequestStructureModel requestStructureModel) {
        return instrumented(ToDoGetTask.class, requestStructureModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestSpecification request = actor.asksFor(SetRequestStructureQuestion.withData(requestStructureModel));
        request.given().when().get();
    }
}
