package com.umld.tasks.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersCreate {

    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("success")
    private boolean success;
    @SerializedName("messages")
    private String messages[];
    @SerializedName("userLoginData")
    private UserLogin.UserLoginData userLoginData;

    public int getStatusCode() {
        return statusCode;
    }

    public boolean getSuccess() {
        return success;
    }

    public String[] getMessages() {
        return messages;
    }

    public UserLogin.UserLoginData getUserLoginData() {
        return userLoginData;
    }



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

    public class UserRegisterData {

        private String userId;
        private String fullname;
        private String username;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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
    }


}
