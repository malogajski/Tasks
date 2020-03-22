package com.umld.tasks.repository;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.umld.tasks.controler.TasksApi;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;
import com.umld.tasks.model.Tasks;

public class TasksRepository extends Repository {


    public TasksRepository(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));
    }

    public void getTasks(String token, final ModelCallback<Tasks> callback){
        createFacade(TasksApi.class)
                .getAllTasks(token)
                .enqueue(generateCallback(callback));
    }

    public void addTask(String token, Tasks.Task task, final ModelCallback<Tasks.Task> callback){
        createFacade(TasksApi.class)
                .addTask(token, task)
                .enqueue(generateCallback(callback));
    }

    public void getTasksById(String token, String id, final ModelCallback<Tasks> callback){
        createFacade(TasksApi.class)
                .getTaskById(token, id)
                .enqueue(generateCallback(callback));
    }
}
