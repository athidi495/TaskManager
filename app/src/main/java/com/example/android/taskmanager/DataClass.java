package com.example.android.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
    int id;
    static String taskName;
    static String taskDueDate;
    static String taskDetail;

    DataClass(int id, String taskName, String taskDueDate, String taskDetail) {
        this.id = id;
        this.taskName = taskName;
        this.taskDueDate = taskDueDate;
        this.taskDetail = taskDetail;
    }

    public DataClass() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public static String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public static String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public static List<DataClass> getData()
    {
        List<DataClass> list = new ArrayList<>();
        list.add(new DataClass(1,"Task1", "29-05-2019", "This is a test task"));
        list.add(new DataClass(2,"Task2", "19-05-2019", "This is a test task.This is a test task.This is a test task.This is a test task.This is a test task.This is a test task.This is a test task.This is a test task.This is a test task.This is a test task"));
        list.add(new DataClass(3,"Task3", "09-05-2019", "This is a test task"));
        return list;
    }


}