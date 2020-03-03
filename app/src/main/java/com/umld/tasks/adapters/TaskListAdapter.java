package com.umld.tasks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.umld.tasks.R;
import com.umld.tasks.model.Tasks;
import java.util.List;

public class TaskListAdapter extends ArrayAdapter<Tasks> {

    private Context mContext;
    int mResource;

    public TaskListAdapter(@NonNull Context context, int resource, @NonNull List<Tasks> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int id = getItem(position).getData().getTasks().get(position).getId();
        String title = getItem(position).getData().getTasks().get(position).getTitle();
        String description = getItem(position).getData().getTasks().get(position).getDescription();
        String completed = getItem(position).getData().getTasks().get(position).getCompleted();
        String deadline = getItem(position).getData().getTasks().get(position).getDeadline();

        Tasks.Task task = new Tasks.Task(id, title, description, completed, deadline);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);
        TextView tvCompleted = convertView.findViewById(R.id.tvCompleted);
        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvDeadline = convertView.findViewById(R.id.tvDeadline);
        LinearLayout taskItem = convertView.findViewById(R.id.taskItem);

        // Set values to task item
        tvTitle.setText(title);
        tvDescription.setText(description);
        tvCompleted.setText(completed);
        tvId.setText(String.valueOf(id));
        tvDeadline.setText(deadline);


        taskItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Clicked to item no:" + id, Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
