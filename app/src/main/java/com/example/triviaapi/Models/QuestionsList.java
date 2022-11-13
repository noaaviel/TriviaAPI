package com.example.triviaapi.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsList {

    @SerializedName("results")
    private List<QuestionModel> results= null;
    @SerializedName("response_code")
    private Integer  response_code;

    public QuestionsList(List<QuestionModel> results, Integer response_code) {
        this.results = results;
        this.response_code = response_code;
    }

    public QuestionsList() {
    }

    public List<QuestionModel> getResults() {
        return results;
    }

    public void setResults(List<QuestionModel> results) {
        this.results = results;
    }

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }
}
