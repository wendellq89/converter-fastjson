package com.wangqian.converterdemo;


import com.wangqian.converter.FastjsonConverterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitClient {
    public static final String API_URL = "https://api.github.com";

    Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(FastjsonConverterFactory.create())
                .build();
    }

    public void getInfo() {
        GitHub github = retrofit.create(GitHub.class);
        Call<List<Contributor>> call = github.contributors("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Response<List<Contributor>> response) {
                for (Contributor contributor : response.body()) {
                    System.out.println(contributor.login + " (" + contributor.contributions + ")");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
