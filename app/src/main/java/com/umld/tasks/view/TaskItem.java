package com.umld.tasks.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umld.tasks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskItem extends Fragment {


    public TaskItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_item, container, false);
    }

}
