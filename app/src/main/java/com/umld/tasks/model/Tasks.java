package com.umld.tasks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Tasks {

    @SerializedName("statusCode")
    @Expose
    private int statusCode;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("messages")
    @Expose
    private List<Object> messages = null;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public List<Object> getMessages() {
        return messages;
    }

    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public static class Task {

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
        private Object deadline;
        @SerializedName("completed")
        @Expose
        private String completed;

        public Task(int id, String title, String description, String completed) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.completed = completed;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public Object getDeadline() {
            return deadline;
        }

        public void setDeadline(Object deadline) {
            this.deadline = deadline;
        }

        public String getCompleted() {
            return completed;
        }

        public void setCompleted(String completed) {
            this.completed = completed;
        }
    }

    public class Data {

        @SerializedName("rows_returned")
        @Expose
        private int rowsReturned;
        @SerializedName("tasks")
        @Expose
        private List<Task> tasks = null;

        public int getRowsReturned() {
            return rowsReturned;
        }

        public void setRowsReturned(int rowsReturned) {
            this.rowsReturned = rowsReturned;
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }

    }
}
