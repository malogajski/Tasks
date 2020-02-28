package com.umld.tasks.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.umld.tasks.model.TasksModel;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<TasksModel> {

    private Context mContext;

    public TaskListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<TasksModel> objects) {
        super(context, resource, objects);
        mContext = context;
    }
}
