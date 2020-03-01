package com.umld.tasks.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umld.tasks.R;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.Tasks;
import com.umld.tasks.repository.TasksRepository;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddTask extends Fragment {

    private TextView dpDeadlineDate;
    private TextView dpDeadlineTime;
    private DatePickerDialog.OnDateSetListener deadlineDateListener;
    private TimePickerDialog.OnTimeSetListener deadlineTimeListener;
    private EditText edTitle;
    private EditText edDescription;
    private CheckBox cbCompleted;
    private TasksRepository addtask;
    private FloatingActionButton addNewTaskFAB;

    private String year, month, day, hour="0", minute="0";


    public AddTask() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);

        // View elements
        edTitle = view.findViewById(R.id.edTitle);
        edDescription = view.findViewById(R.id.edDescription);
        cbCompleted = view.findViewById(R.id.cbCompleted);
        addNewTaskFAB = view.findViewById(R.id.saveNewTask);
        dpDeadlineDate = view.findViewById(R.id.dpDeadline);
        dpDeadlineTime = view.findViewById(R.id.dpDeadlineTime);


        dpDeadlineDate.setOnClickListener((View view1) -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(getActivity(), 0, deadlineDateListener, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
            dialog.show();
        });

        deadlineDateListener = (datePicker, year, month, day) -> {
            month = month+1;
            String date = day + "." + month + "." + year;
            this.day = day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
            this.month = month < 10 ? "0" + String.valueOf(month) : String.valueOf(month);
            this.year = year < 10 ? "0" + String.valueOf(year) : String.valueOf(year);

            dpDeadlineDate.setText(date);

        };

        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()); //DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
        dpDeadlineTime.setText(currentTime);

        dpDeadlineTime.setOnClickListener(view1 -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            this.hour = hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour);
            this.minute = minute < 10 ? "0" + String.valueOf(minute) : String.valueOf(minute);

            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), 0, deadlineTimeListener, hour, minute, true);
            timePickerDialog.show();
        });
        deadlineTimeListener = (timePicker, hour, minute) -> {
            String time = hour + ":" + minute;
            this.hour = hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour);
            this.minute = minute < 10 ? "0" + String.valueOf(minute) : String.valueOf(minute);
            dpDeadlineTime.setText(time);
        };

        SharedPreferences preferences = getActivity().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);

        // set repository
        addtask = new TasksRepository(getActivity());

        addNewTaskFAB.setOnClickListener(view12 -> {

            if(this.hour == "0" && this.minute == "0") {
                String strTime = dpDeadlineTime.getText().toString();

                SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
                Calendar c = Calendar.getInstance();
                try {
                    c.setTime(dateFormatter.parse(strTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                this.hour = c.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) : String.valueOf(c.get(Calendar.HOUR_OF_DAY));
                this.minute = c.get(Calendar.MINUTE) < 10 ? "0" + String.valueOf(c.get(Calendar.MINUTE)) : String.valueOf(c.get(Calendar.MINUTE));
            }
            String dateSep = "/";
            String dateTime = this.day + dateSep + this.month + dateSep + this.year + " " + this.hour + ":" +this.minute;

            Tasks.Task task = new Tasks.Task(0, edTitle.getText().toString(), edDescription.getText().toString(), "N", dateTime);

            task.setTitle(edTitle.getText().toString());
            task.setDescription(edDescription.getText().toString());
            task.setDeadline(dateTime);
            task.setCompleted("N"); //   task.setCompleted(cbCompleted.getText().toString());



            addtask.addTask(retrivedToken, task, new ModelCallback<Tasks.Task>() {
                @Override
                public void onResult(Tasks.Task result) {
                    Toast.makeText(getContext(), "Task saved successfully!", Toast.LENGTH_SHORT).show();
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.mainFrame, new TaskList(), null).commit();
                }

                @Override
                public void onError(ModelError error) {
                    Toast.makeText(getContext(), "Task NOT saved!", Toast.LENGTH_SHORT).show();
                }
            });
        });


        return view;
    }
}
