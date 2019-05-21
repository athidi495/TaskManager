package com.example.android.taskmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    List<DataClass> taskList = Collections.emptyList();
    Context context;

    public RecyclerAdapter(List<DataClass> taskList, Context context){
        this.taskList =taskList;
        this.context =context;
    }
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View taskView = inflater.inflate(R.layout.taskitemview,parent,false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(taskView);

        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskViewHolder viewHolder, final int position) {
        viewHolder.taskName.setText(taskList.get(position).taskName);
        viewHolder.taskDueDate.setText(taskList.get(position).taskDueDate);
        viewHolder.taskDetail.setText(taskList.get(position).taskDetail);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
    private List<DataClass> getData()
    {
        List<DataClass> list = new ArrayList<>();
        list.add(new DataClass("1", "Task1", "29-05-2019"));
        list.add(new DataClass("2", "Task2", "19-05-2019"));
        list.add(new DataClass("3", "Task3", "09-05-2019"));
        return list;
    }
}
