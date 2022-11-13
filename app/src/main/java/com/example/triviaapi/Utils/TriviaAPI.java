package com.example.triviaapi.Utils;

import com.example.triviaapi.Models.CategoryList;
import com.example.triviaapi.Models.QuestionsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TriviaAPI {


    @GET("/api_category.php")
    Call<CategoryList> doCallListOfCategories();

    @GET("/api.php?amount=10")
    Call<QuestionsList> doCallQuestionListByCategory(
            @Query("category") Integer category_id
    );

}
