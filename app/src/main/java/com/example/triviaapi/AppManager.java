package com.example.triviaapi;

import android.app.Application;

import com.example.triviaapi.Utils.TriviaAPI;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppManager extends Application {

    private static Retrofit retrofit= new Retrofit.Builder().baseUrl("https://opentdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient().newBuilder().addInterceptor(newInterceptor()).build())
            .build();

    // now with retrofit we can create jsonplaceholder
    //https://opentdb.com/api_config.php
    static TriviaAPI jsonPlaceHolder = retrofit.create(TriviaAPI.class);


    private static Interceptor newInterceptor() {

        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original =chain.request();
                // HttpUrl httpUrl = original.url().newBuilder().addQueryParameter("api_key","3930eda0423c873bc5ce559094909f9d").build();
                HttpUrl httpUrl1 = original.url().newBuilder().build();
                original = original.newBuilder().url(httpUrl1).build();
                return chain.proceed(original);


            }
        };

        /*
        Session Tokens will be deleted after 6 hours of inactivity.
        Using a Session Token:
        https://opentdb.com/api.php?amount=10&token=YOURTOKENHERE
        Retrieve a Session Token:
        https://opentdb.com/api_token.php?command=request
        Reset a Session Token:
        https://opentdb.com/api_token.php?command=reset&token=YOURTOKENHERE

         */

    }
}
