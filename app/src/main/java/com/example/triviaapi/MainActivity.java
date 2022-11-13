package com.example.triviaapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.triviaapi.Models.CategoryList;
import com.example.triviaapi.Models.CategoryModel;
import com.example.triviaapi.Models.QuestionModel;
import com.example.triviaapi.Models.QuestionsList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView1;
    List<CategoryModel> categoryModels;
    List<QuestionModel> questionModels;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        textView1 = findViewById(R.id.text1);
        recyclerView = findViewById(R.id.recyclerView);
        categoryModels = new ArrayList<>();
        questionModels = new ArrayList<>();
        Call<CategoryList> categoryListCall = AppManager.jsonPlaceHolder.doCallListOfCategories();

        categoryListCall.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                List<CategoryModel> modelList = response.body().getTriviaCategories();
                String displayResponse="";
                for (int i=0 ; i<modelList.size();i++){
                    CategoryModel m =new CategoryModel();
                    m.setId(modelList.get(i).getId());
                    m.setName(modelList.get(i).getName());
                    categoryModels.add(m);
                    displayResponse += m.getId() + " " + m.getName() + "\n";
                }

              //  textView.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                Log.d("noa",t.getMessage());
            }
        });

        Call<QuestionsList> questionsListCall = AppManager.jsonPlaceHolder.doCallQuestionListByCategory(10);
        questionsListCall.enqueue(new Callback<QuestionsList>() {
            @Override
            public void onResponse(Call<QuestionsList> call, Response<QuestionsList> response) {
                List<QuestionModel> modelList = response.body().getResults();

                String displayResponse="";
                for (int i=0 ; i<modelList.size();i++){
                    QuestionModel m =new QuestionModel();
                    m.setCategory(modelList.get(i).getCategory());
                    m.setCorrect(modelList.get(i).getCorrect());
                    m.setDifficulty(modelList.get(i).getDifficulty());
                    m.setQuestion(modelList.get(i).getQuestion());
                    m.setType(modelList.get(i).getType());
                    m.setIncorrect(modelList.get(i).getIncorrect());
                    questionModels.add(m);
                    displayResponse += m.getCategory() + " " + m.getDifficulty()+ " " + m.getQuestion()
                            + " " + m.getType()+ " " + m.getCorrect()+ " " + m.getIncorrect()+ "\n";
                }

                //textView1.setText(displayResponse);
                textView.setText("");
                PutDataIntoRecyclerView(modelList);

            }

            @Override
            public void onFailure(Call<QuestionsList> call, Throwable t) {
                Log.d("noa",t.getMessage());

            }
        });
    }

    private void PutDataIntoRecyclerView(List<QuestionModel> questionModels){
        RecyclerAdapter adapter = new RecyclerAdapter(this,questionModels);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        recyclerView.setAdapter(adapter);
    }
}