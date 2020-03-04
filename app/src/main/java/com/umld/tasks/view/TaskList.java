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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umld.tasks.R;
import com.umld.tasks.adapters.RecAdapter;
import com.umld.tasks.adapters.TaskListAdapter;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.Tasks;
import com.umld.tasks.repository.TasksRepository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskList extends Fragment {

    private TextView noData;
//    private ListView listView;
    private FloatingActionButton addNewTask;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    TasksRepository taskRepo;

    public TaskList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

//        noData = view.findViewById(R.id.emptyTextView);
//        listView = view.findViewById(R.id.itemsListView);
        addNewTask = view.findViewById(R.id.addNewTask);
        // ReyclerView settings
        mRecyclerView = view.findViewById(R.id.itemsListView);
        mRecyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);




        SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);

        // Add new task from FAB
        addNewTask.setOnClickListener(view1 ->MainActivity.fragmentManager
                .beginTransaction()
                .replace(R.id.mainFrame, new AddTask(), null)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit());

        // Show tasks
        taskRepo = new TasksRepository(getActivity());
        taskRepo.getTasks(retrivedToken, new ModelCallback<Tasks>() {
            @Override
            public void onResult(Tasks tasks) {

                int taskSize = tasks.getData().getTasks().size();

//                if (taskSize > 0) {
//                    noData.setVisibility(View.INVISIBLE);
//                }

//                ArrayList<Tasks> arr = new ArrayList<>();
//                for (int x = 0; x < taskSize; x++) {
//                    arr.add(x,tasks);
//                }

                ArrayList<Tasks> recList = new ArrayList<>();
                for (int x = 0; x < taskSize; x++) {
                    recList.add(x,tasks);
                }

                mLayoutManager = new LinearLayoutManager(getContext());
                mAdapter = new RecAdapter(recList);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

                /*
                TaskListAdapter adapter = new TaskListAdapter(getContext(), R.layout.fragment_task_item, arr);
                listView.setAdapter(adapter);
                 */
            }

            @Override
            public void onError(ModelError error) {
                Toast.makeText(getActivity(), "Nema podataka!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
