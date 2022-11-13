package com.example.triviaapi.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryCountModel {

    @SerializedName("category_id")
    private Integer id;
    @SerializedName("category_question_count")
    private List<CategoryQuestCount> category_question_count=null;

    public CategoryCountModel(Integer id, List<CategoryQuestCount> category_question_count) {
        this.id = id;
        this.category_question_count = category_question_count;
    }

    public CategoryCountModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CategoryQuestCount> getCategory_question_count() {
        return category_question_count;
    }

    public void setCategory_question_count(List<CategoryQuestCount> category_question_count) {
        this.category_question_count = category_question_count;
    }

    /*{
"category_id": 9,
"category_question_count": {
"total_question_count": 300,
"total_easy_question_count": 118,
"total_medium_question_count": 123,
"total_hard_question_count": 59
}
}*/
}
