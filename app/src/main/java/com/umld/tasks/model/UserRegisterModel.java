package com.umld.tasks.model;

import java.util.List;

public class UserRegisterModel {

    private int statusCode;
    private boolean success;
    private List<String> messages = null;
    private UserRegisterData data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public UserRegisterData getData() {
        return data;
    }

    public void setData(UserRegisterData data) {
        this.data = data;
    }
}
