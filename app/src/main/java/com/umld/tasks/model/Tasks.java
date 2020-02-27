package com.umld.tasks.model;

import android.app.DownloadManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.umld.tasks.repository.TasksRepository;

import java.util.Date;

public class Tasks {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("deadline")
    @Expose
    private Date deadline;

    @SerializedName("completed")
    @Expose
    private char completed = 'N';

    @SerializedName("userid")
    @Expose
    private int userid;


    public Tasks(String title, String description, Date deadline, char completed, int userid) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = completed;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public char getCompleted() {
        return completed;
    }

    public void setCompleted(char completed) {
        this.completed = completed;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}


