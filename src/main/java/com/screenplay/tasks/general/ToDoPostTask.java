package com.screenplay.tasks.general;


import com.screenplay.models.general.RequestStructureModel;
import com.screenplay.questions.general.SetRequestStructureQuestion;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ToDoPostTask implements Task {

    private final RequestStructureModel requestStructureModel;

    public ToDoPostTask(RequestStructureModel requestStructureModel) {
        this.requestStructureModel = requestStructureModel;
    }

    public static ToDoPostTask doPost(RequestStructureModel requestStructureModel) {
        return instrumented(ToDoPostTask.class, requestStructureModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestSpecification request = actor.asksFor(SetRequestStructureQuestion.withData(requestStructureModel));
        request.given().when().post();
    }
}
