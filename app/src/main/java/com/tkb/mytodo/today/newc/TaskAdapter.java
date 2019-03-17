package com.tkb.mytodo.today.newc;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tkb.mytodo.R;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends PagedListAdapter<TaskModel, TaskAdapter.ItemViewHolder> {

    private Context mCtx;

    public TaskAdapter(Context mCtx) {
        super(CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.row_today_fragment, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        TaskModel contact = getItem(position);

        if (contact != null) {
            holder.txtTask.setText("Name: "+contact.getTitle());
            holder.txtDescription.setText("Number: "+contact.getDescription());
        } else {
            Toast.makeText(mCtx, Constants.YOU_DONT_HAVE_ANY_DATA, Toast.LENGTH_LONG).show();
        }

    }


    private static DiffUtil.ItemCallback<TaskModel> CALLBACK =
            new DiffUtil.ItemCallback<TaskModel>() {

                @Override
                public boolean areItemsTheSame(@NonNull TaskModel oldItem, @NonNull TaskModel newItem) {
                    return false;
                }

                @Override
                public boolean areContentsTheSame(TaskModel oldItem, TaskModel newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView txtTask,txtDescription;

        public ItemViewHolder(View itemView) {
            super(itemView);

            txtTask = itemView.findViewById(R.id.txtTask);
            txtDescription = itemView.findViewById(R.id.txtDescription);

        }
    }
}
