package com.example.triviaapi.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionModel {

    @SerializedName("category")
    private String category;
    @SerializedName("type")
    private String type;
    @SerializedName("difficulty")
    private String difficulty;
    @SerializedName("question")
    private String question;
    @SerializedName("correct_answer")
    private String correct; //can be string true/false
    @SerializedName("incorrect_answers")
    private List<String> incorrect = null; // can be string true or false

    public QuestionModel(String category, String type, String difficulty, String question, String correct, List<String> incorrect) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct = correct;
        this.incorrect = incorrect;
    }

    public QuestionModel() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(List<String> incorrect) {
        this.incorrect = incorrect;
    }

/*
    *
"category": "Entertainment: Film",
"type": "multiple",
"difficulty": "easy",
"question": "What was the first James Bond film?",
"correct_answer": "Dr. No",
"incorrect_answers": [
"Goldfinger",
"From Russia With Love",
"Thunderball"
]
    *
    *
    * */
}
