package com.leo.oscarapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        //inform Webservice base URL
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.179:12345/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public UserService getUserService() {
        return this.retrofit.create(UserService.class);
    }

}
