package com.devnity.ecomate.api;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserService {

    @POST("/user/login")
    Call<Object> loginUser(@Body() JsonObject object);
}
