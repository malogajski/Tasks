package com.umld.tasks.repository;

import android.app.Activity;

import com.umld.tasks.controler.UserCreate;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;
import com.umld.tasks.model.UsersCreate;

public class RegisterRepository extends Repository {

    public RegisterRepository(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));
    }

    public void getRegistredUser(RegisterCredentials registerCredentials, final ModelCallback<UsersCreate> callback) {
        createFacade(UserCreate.class)
                .getRegistredUser(registerCredentials)
                .enqueue(generateCallback(callback));
    }
}
