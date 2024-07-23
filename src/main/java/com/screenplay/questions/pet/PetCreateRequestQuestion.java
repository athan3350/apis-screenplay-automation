package com.screenplay.questions.pet;

import com.screenplay.models.pet.CategoryModel;
import com.screenplay.models.pet.CreatePetModel;
import com.screenplay.models.pet.TagsItemModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PetCreateRequestQuestion implements Question<CreatePetModel> {

    private final List<Map<String, String>> dataRequest;
    Map<String, String> data = new HashMap<>();
    List<TagsItemModel> tags = new ArrayList<>();
    List<String> photosUrl = new ArrayList<>();


    public PetCreateRequestQuestion(List<Map<String, String>> dataRequest) {
        this.dataRequest = dataRequest;
    }

    public static PetCreateRequestQuestion withData(List<Map<String, String>> dataRequest) {
        return new PetCreateRequestQuestion(dataRequest);
    }

    @Override
    public CreatePetModel answeredBy(Actor actor) {
        data.putAll(dataRequest.get(0));

        tags.add(TagsItemModel
                .builder()
                .id(Integer.parseInt(data.get("tags.id")))
                .name(data.get("name"))
                .build());

        photosUrl.add(data.get("photoUrls"));

        return CreatePetModel
                .builder()
                .id(Integer.parseInt(data.get("id")))
                .category(CategoryModel.builder()
                        .id(Integer.parseInt(data.get("category.id")))
                        .name(data.get("category.name"))
                        .build())
                .name(data.get("name"))
                .photoUrls(photosUrl)
                .tags(tags)
                .status(data.get("status"))
                .build();


    }
}
