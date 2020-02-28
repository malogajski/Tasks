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

import com.umld.tasks.R;
import com.umld.tasks.adapters.TaskListAdapter;
import com.umld.tasks.controler.Tasks;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.TaskDetails;
import com.umld.tasks.model.TasksModel;
import com.umld.tasks.repository.TasksRepository;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskList extends Fragment {

    private TextView textView;
    private ListView listView;
    TasksRepository taskRepo;

    public TaskList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        textView = view.findViewById(R.id.emptyTextView);
        listView = view.findViewById(R.id.itemsListView);

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);//second parameter default value.
/*
        taskRepo = new TasksRepository(getActivity());
        taskRepo.getTasks(new TasksRepository(getActivity()), new ModelCallback<Tasks>() {
            @Override
            public void onResult(TasksModel result) {
                ArrayList<TasksModel> result1 = new ArrayList<>();
                int velicina = result1.size();

                if (velicina > 0)
                    Toast.makeText(getContext(), "velicina je: "+ velicina, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "Velicina tasks ArryList je: 0", Toast.LENGTH_SHORT).show();

//                TaskListAdapter adapter = new TaskListAdapter(getContext(), R.layout.fragment_task_list, result);
//                listView.setAdapter(adapter);
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(getActivity(), "Nema podataka!", Toast.LENGTH_SHORT).show();
            }
        });
//        textView.setText(retrivedToken);
*/


        return view;
    }



}
