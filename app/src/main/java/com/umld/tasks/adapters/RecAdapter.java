package com.umld.tasks.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.umld.tasks.R;
import com.umld.tasks.model.Tasks;
import com.umld.tasks.view.AddTask;
import com.umld.tasks.view.MainActivity;
import com.umld.tasks.view.TaskList;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> {

    private ArrayList<Tasks> mRecList;
    private Context mContext;
    public static String idSelectedTask;

    public static class RecViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        TextView tvCompleted;
        TextView tvId;
        TextView tvDeadline;
        RelativeLayout relativeLayout;


        public RecViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDeadline = itemView.findViewById(R.id.tvDeadline);
            tvCompleted = itemView.findViewById(R.id.tvCompleted);
            relativeLayout = itemView.findViewById(R.id.taskItem);
        }
    }

    public RecAdapter(ArrayList<Tasks> recList) {
        mRecList = recList;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task_item, parent, false);
        RecViewHolder rvh = new RecViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, int position) {

        mContext = holder.tvTitle.getContext();

        Tasks currentItem = mRecList.get(position);

        int id = currentItem.getData().getTasks().get(position).getId();
        String title = currentItem.getData().getTasks().get(position).getTitle();
        String description = currentItem.getData().getTasks().get(position).getDescription();
        String completed = currentItem.getData().getTasks().get(position).getCompleted();
        String deadline = currentItem.getData().getTasks().get(position).getDeadline();

        holder.tvId.setText(String.valueOf(id));
        holder.tvTitle.setText(title);
        holder.tvDescription.setText(description);
        holder.tvCompleted.setText(completed);
        holder.tvDeadline.setText(deadline);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idSelectedTask = String.valueOf(id);
                Toast.makeText(mContext, "Clicked to item no:" + id, Toast.LENGTH_SHORT).show();
//                MainActivity.fragmentManager
//                        .beginTransaction()
//                        .replace(R.id.mainFrame, new AddTask(), null)
//                        .addToBackStack(null)
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecList.size();
    }


}
