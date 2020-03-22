package com.umld.tasks.controler;

import com.umld.tasks.model.Tasks;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TasksApi {

    @Headers("Content-Type: application/json")
    @GET("/tasks/v1/tasks")
    Call<Tasks> getAllTasks(@Header("authorization") String token);

    @Headers("Content-Type: application/json")
    @GET("/tasks/v1/tasks/{id}")
    Call<Tasks> getTaskById(@Header("authorization") String token, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @POST("/tasks/v1/tasks")
    Call<Tasks.Task> addTask(@Header("authorization") String token, @Body Tasks.Task task);
}
