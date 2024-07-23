package com.screenplay.tasks.general;

import com.screenplay.constants.GeneralConstants;
import com.screenplay.constants.KeysToRememberConstants;
import com.screenplay.utilities.GetDataFromJsonFile;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;


public class ValidateStructureResponseTask implements Task {

    private final List<Map<String, String>> structureData;
    Map<String, String> data = new HashMap<>();

    public ValidateStructureResponseTask(List<Map<String, String>> structureData) {
        this.structureData = structureData;
    }


    public static ValidateStructureResponseTask doValidate(List<Map<String, String>> structureData) {
        return instrumented(ValidateStructureResponseTask.class, structureData);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        structureData.get(0).forEach(data::put);

        actor.should(
                seeThatResponse(response -> response.statusCode(Integer.parseInt(data.get(GeneralConstants.STATUS_CODE)))),
                seeThatResponse(response -> response.statusLine(containsString(data.get(GeneralConstants.STATUS_MESSAGE))))
        );

        if (data.get(GeneralConstants.SCHEMA_PATH) == null) return;

        GetDataFromJsonFile generalUtilities = new GetDataFromJsonFile();
        JSONObject jsonSchema = new JSONObject(generalUtilities.getJsonFileAsJSONObject("src/main/resources/schemes/" + structureData.get(0).get(GeneralConstants.SCHEMA_PATH) + ".json"));
        JSONObject jsonSubject = new JSONObject(actor.asksFor(LastResponse.received()).getBody().asString());
        SchemaLoader.load(jsonSchema).validate(jsonSubject);

        actor.remember(KeysToRememberConstants.HTTP_CODE_TO_VALIDATE, data.get(GeneralConstants.STATUS_CODE));
        actor.remember(KeysToRememberConstants.HTTP_MESSAGE_TO_VALIDATE, data.get(GeneralConstants.STATUS_MESSAGE));
    }
}
