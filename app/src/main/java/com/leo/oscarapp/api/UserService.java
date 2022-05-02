package com.leo.oscarapp.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("auth")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}
