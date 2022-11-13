package com.example.triviaapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapi.Models.QuestionModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private Context mContext;
    private List<QuestionModel> mData;


    public RecyclerAdapter(Context mContext, List<QuestionModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.question_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.category.setText(mData.get(position).getCategory());
        holder.correct.setText(mData.get(position).getCorrect());
        holder.difficulty.setText(mData.get(position).getDifficulty());
        holder.question.setText(mData.get(position).getQuestion());
        //holder.incorrect.setText(mData.get(position).getIncorrect());
        holder.type.setText(mData.get(position).getType());
        String displayResponse="";
        for (int i=0;i<mData.get(position).getIncorrect().size();i++){
            displayResponse+= mData.get(position).getIncorrect().get(i) + " \n";
        }
        holder.incorrect.setText(displayResponse);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category,type,difficulty,question,correct,incorrect;

        //Holds a card view of a question
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            init();
        }

        private void init() {
            category= itemView.findViewById(R.id.category_text);
            type=itemView.findViewById(R.id.type_text);
            difficulty=itemView.findViewById(R.id.difficulty_text);
            question=itemView.findViewById(R.id.question_text);
            correct= itemView.findViewById(R.id.category_text);
            incorrect=itemView.findViewById(R.id.incorrect_text);

        }

    }
}
