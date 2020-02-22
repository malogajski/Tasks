package com.umld.tasks.repository;

import android.app.Activity;

import com.umld.tasks.controler.UserRegister;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;
import com.umld.tasks.model.Users;

public class RegisterRepository extends Repository {

    public RegisterRepository(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));
    }

    public void getRegistredUser(RegisterCredentials registerCredentials, final ModelCallback<Users> callback) {
        createFacade(UserRegister.class)
                .getRegistredUser(registerCredentials)
                .enqueue(generateCallback(callback));
    }
}
