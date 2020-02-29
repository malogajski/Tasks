package com.umld.tasks.controler;

import com.umld.tasks.model.Tasks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TasksApi {

    @Headers("Content-Type: application/json")
    @GET("/tasks/v1/tasks")
    Call<Tasks> getAllTasks(@Header("authorization") String token);

    @Headers("Content-Type: application/json")
    @POST("/tasks/v1/tasks")
    Call<Tasks.Task> addTask(@Header("authorization") String token);
}
