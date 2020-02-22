package com.umld.tasks.controler;

import com.umld.tasks.model.Sessions;
import com.umld.tasks.repository.UserCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserLogin {

    @Headers("Content-Type: application/json")
    @POST("/tasks/v1/sessions")
    Call<Sessions> getLoginSession(@Body UserCredentials userCredentials);
}
