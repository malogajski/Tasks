package com.umld.tasks.repository;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.umld.tasks.controler.Tasks;
import com.umld.tasks.model.AllTasks;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;
import com.umld.tasks.model.TasksModel;

public class TasksRepository extends Repository {

    String token;

    public TasksRepository(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));

        SharedPreferences preferences = activity.getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        token  = preferences.getString("TOKEN",null);
    }

    public void getTasks(TasksRepository tasksRepository, final ModelCallback<Tasks> callback){

        createFacade(Tasks.class)
                .getAllTasks(token)
                .enqueue(generateCallback(callback));
    }
}
