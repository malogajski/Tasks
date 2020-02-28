package com.umld.tasks.repository;

import android.app.Activity;
import com.umld.tasks.controler.UserLogin;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelErrorFactory;
import com.umld.tasks.model.Sessions;

public class UserRepsitory extends Repository {

    public UserRepsitory(Activity activity) {
        setModelErrorFactory(new ModelErrorFactory(activity));
    }

    public void getUser(UserCredentials userCredentials, final ModelCallback<Sessions> callback){
        createFacade(UserLogin.class)
                .getLoginSession(userCredentials)
                .enqueue(generateCallback(callback));
    }

}
