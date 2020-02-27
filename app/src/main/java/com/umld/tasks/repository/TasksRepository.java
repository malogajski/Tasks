package com.umld.tasks.repository;

import android.app.Activity;

import com.umld.tasks.controler.Tasks;
import com.umld.tasks.model.AllTasks;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;

public class TasksRepository extends Repository {

    public TasksRepository(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));
    }

    public void getTasks(TasksRepository tasksRepository, final ModelCallback<AllTasks> callback){
        createFacade(Tasks.class)
                .getAllTasks("ovde ubaci token..")
                .enqueue(generateCallback(callback));
    }
}
