package com.umld.tasks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umld.tasks.R;
import com.umld.tasks.model.Tasks;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> {

    private ArrayList<Tasks> mRecList;

    public static class RecViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;
        TextView tvCompleted;
        TextView tvId;
        TextView tvDeadline;
//        LinearLayout taskItem;

        public RecViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvDeadline = itemView.findViewById(R.id.tvDeadline);
            tvCompleted = itemView.findViewById(R.id.tvCompleted);
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
    }

    @Override
    public int getItemCount() {
        return mRecList.size();
    }


}
