package com.umld.tasks.repository;

import com.umld.tasks.controler.UserRegister;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.Users;

public class RegisterCredentials {

    private String fullname;
    private String username;
    private String password;

    public RegisterCredentials(String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
