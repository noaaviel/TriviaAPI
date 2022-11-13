package com.example.triviaapi.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryList {


    @SerializedName("trivia_categories")
    List<CategoryModel> triviaCategories = null;

    public CategoryList(List<CategoryModel> triviaCategories) {
        this.triviaCategories = triviaCategories;
    }

    public CategoryList() {
    }

    public List<CategoryModel> getTriviaCategories() {
        return triviaCategories;
    }

    public void setTriviaCategories(List<CategoryModel> triviaCategories) {
        this.triviaCategories = triviaCategories;
    }
}
