package com.umld.tasks.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.umld.tasks.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTask extends Fragment {

    private TextView dpDeadline;
    private DatePickerDialog.OnDateSetListener dpDeadlineListener;
    private EditText edTitle;
    private EditText edDescription;
    private CheckBox cbCompleted;



    public AddTask() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        // View elements
        edTitle = view.findViewById(R.id.edTitle);
        edDescription = view.findViewById(R.id.edDescription);
        cbCompleted = view.findViewById(R.id.cbCompleted);

        // Display date picker on click deadline field
        dpDeadline = view.findViewById(R.id.dpDeadline);
        dpDeadline.setOnClickListener(view1 -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    getActivity(),
                    0,
                    dpDeadlineListener,
                    year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            dialog.show();
        });
        dpDeadlineListener = (datePicker, year, month, day) -> {
            String date = day + "." + month + "." + year;
            dpDeadline.setText(date);
        };

        // Get Token for future actions
        SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);




        return view;
    }
}
