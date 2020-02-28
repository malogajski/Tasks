package com.umld.tasks.controler;

import com.umld.tasks.model.AllTasks;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface Tasks {

    @GET("/tasks/v1/tasks")
    Call<Tasks> getAllTasks(@Header("authorization") String token);
}
