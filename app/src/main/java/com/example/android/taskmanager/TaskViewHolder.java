package com.example.android.taskmanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TaskViewHolder extends RecyclerView.ViewHolder {


    TextView taskName;
    TextView taskDueDate;
    TextView taskDetail;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskName = (TextView)itemView.findViewById(R.id.textView_Task);
        taskDueDate = (TextView)itemView.findViewById(R.id.textView_dueDate);
        taskDetail = (TextView)itemView.findViewById(R.id.textViewDescription);
    }
}
