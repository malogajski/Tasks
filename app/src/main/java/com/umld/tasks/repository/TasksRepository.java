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
}
