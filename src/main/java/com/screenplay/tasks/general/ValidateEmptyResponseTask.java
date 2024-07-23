package com.screenplay.tasks.general;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateEmptyResponseTask implements Task {


    public static ValidateEmptyResponseTask doValidate() {
        return instrumented(ValidateEmptyResponseTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Ensure.that(actor.asksFor(LastResponse.received()).getBody().asString()).isEmpty()
        );

    }

}
