package com.screenplay.models.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetModel {
	private List<String> photoUrls;
	private String name;
	private int id;
	private CategoryModel category;
	private List<TagsItemModel> tags;
	private String status;
}