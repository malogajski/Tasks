package com.umld.tasks.controler;

import com.umld.tasks.model.UsersCreate;
import com.umld.tasks.repository.RegisterCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserCreate {

    @Headers("Content-Type: application/json")
    @POST("/tasks/v1/users")
    Call<UsersCreate> getRegistredUser(@Body RegisterCredentials newUser);

    /*
    @Headers("Content-Type: application/json")
    @POST("/tasks/v1/sessions")
    Call<Sessions> getLoginSession(@Body UserCredentials userCredentials);



    @Field("fullname") String fullname,
            @Field("username") String username,
            @Field("password") String password
    * */
}
