package com.umld.tasks.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umld.tasks.R;
import com.umld.tasks.adapters.TaskListAdapter;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.Tasks;
import com.umld.tasks.repository.TasksRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskList extends Fragment {

    private TextView noData;
    private ListView listView;
    private FloatingActionButton addNewTask;

    TasksRepository taskRepo;

    public TaskList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        noData = view.findViewById(R.id.emptyTextView);
        listView = view.findViewById(R.id.itemsListView);

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);//second parameter default value.

        // Add new task from FAB
        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Show tasks
        taskRepo = new TasksRepository(getActivity());
        taskRepo.getTasks(retrivedToken, new ModelCallback<Tasks>() {
            @Override
            public void onResult(Tasks tasks) {

                int taskSize = tasks.getData().getTasks().size();

                if (taskSize > 0) {
                    noData.setVisibility(View.INVISIBLE);
                }

                ArrayList<Tasks> arr = new ArrayList<>();
                for (int x = 0; x < taskSize; x++) {
                    arr.add(x,tasks);
                }

                TaskListAdapter adapter = new TaskListAdapter(getContext(), R.layout.fragment_task_item, arr);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(getActivity(), "Nema podataka!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



}
