package com.umld.tasks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllTasksData {

    @SerializedName("rows_returned")
    @Expose
    private Integer rowsReturned;
    @SerializedName("tasks")
    @Expose
    private List<TaskDetails> tasks = null;

    public Integer getRowsReturned() {
        return rowsReturned;
    }

    public void setRowsReturned(Integer rowsReturned) {
        this.rowsReturned = rowsReturned;
    }

    public List<TaskDetails> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDetails> tasks) {
        this.tasks = tasks;
    }
}
