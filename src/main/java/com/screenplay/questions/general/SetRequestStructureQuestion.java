package com.screenplay.questions.general;

import com.screenplay.constants.KeysToRememberConstants;
import com.screenplay.models.general.RequestStructureModel;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.rest;

public class SetRequestStructureQuestion implements Question<RequestSpecification> {

    private final RequestStructureModel requestStructureModel;

    public SetRequestStructureQuestion(RequestStructureModel requestStructureModel) {
        this.requestStructureModel = requestStructureModel;
    }

    public static SetRequestStructureQuestion withData(RequestStructureModel requestStructureModel) {
        return new SetRequestStructureQuestion(requestStructureModel);
    }

    @Override
    public RequestSpecification answeredBy(Actor actor) {


        RequestSpecification request = rest();
        request.baseUri(actor.recall(KeysToRememberConstants.BASE_URI_ACTOR));

        if (requestStructureModel.getBaseUri() != null)
            request.baseUri(requestStructureModel.getBaseUri());
        if (requestStructureModel.getBasePath() != null)
            request.basePath(requestStructureModel.getBasePath());
        if (requestStructureModel.getContentType() != null)
            request.contentType(requestStructureModel.getContentType());
        if (requestStructureModel.getFormBody() != null)
            request.formParams(requestStructureModel.getFormBody());
        if (requestStructureModel.getJsonBody() != null)
            request.body(requestStructureModel.getJsonBody());
        if (requestStructureModel.getPathParams() != null)
            request.pathParams(requestStructureModel.getPathParams());
        if (requestStructureModel.getHeaders() != null)
            request.headers(requestStructureModel.getHeaders());
        if (requestStructureModel.getQueryParamsSameKey() != null) {
            request.queryParams(requestStructureModel.getQueryParamsSameKey().asMap());
        }
        if (requestStructureModel.getQueryParams() != null)
            request.queryParams(requestStructureModel.getQueryParams());

        if (requestStructureModel.getHasPassword() != null) {
            request.auth().basic("", "");
            return request;
        }

        return request;

    }
}