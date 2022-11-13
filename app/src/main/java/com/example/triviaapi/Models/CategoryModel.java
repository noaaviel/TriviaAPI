package com.example.triviaapi.Models;

import com.google.gson.annotations.SerializedName;

public class CategoryModel {

    /*"id": 9,
"name": "General Knowledge"*/

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    public CategoryModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
