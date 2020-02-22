package com.umld.tasks.model;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("success")
    private boolean success;
    @SerializedName("messages")
    private String messages[];
    @SerializedName("userLoginData")
    private UserLoginData userLoginData;

    public int getStatusCode() {
        return statusCode;
    }

    public boolean getSuccess() {
        return success;
    }

    public String[] getMessages() {
        return messages;
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }
}
