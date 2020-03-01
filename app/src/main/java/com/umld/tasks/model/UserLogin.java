package com.umld.tasks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("useractive")
    @Expose
    private char userActive;


    public UserLogin(int id, String fullname, String username, String password, char userActive) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.userActive = userActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public char getUserActive() {
        return userActive;
    }

    public void setUserActive(char userActive) {
        this.userActive = userActive;
    }


    public class UserLoginData {

        private String session_id;
        private String access_token;

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }
    }
}
