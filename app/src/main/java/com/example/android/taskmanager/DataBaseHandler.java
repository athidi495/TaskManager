package com.example.android.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TaskManager";
    private static final String TABLE_TASKS = "TASKS";
    private static final String KEY_ID = "id";
    private static final String KEY_TASKNAME = "TaskName";
    private static final String KEY_DUE_DATE = "DueDate";
    private static final String KEY_TASK_DETAIL = "TaskDetail";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TASKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TASKNAME + " TEXT,"
                + KEY_DUE_DATE + " TEXT,"
                + KEY_TASK_DETAIL + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new Task
    void addTask(DataClass dataClass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TASKNAME, DataClass.getTaskName()); // Task Name
        values.put(KEY_DUE_DATE, DataClass.getTaskDueDate()); // Task Due Date
        values.put(KEY_TASK_DETAIL, DataClass.getTaskDetail()); // Task Due Date
        // Inserting Row
        db.insert(TABLE_TASKS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    DataClass getTask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TASKS, new String[] { KEY_ID,
                        KEY_TASKNAME, KEY_DUE_DATE, KEY_TASK_DETAIL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        DataClass task = new DataClass(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3) );
        // return Task
        return task;
    }

    // code to get all contacts in a list view
    public List<DataClass> getAllTasks() {
        List<DataClass> taskList = new ArrayList<DataClass>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataClass task = new DataClass();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setTaskName(cursor.getString(1));
                task.setTaskDueDate(cursor.getString(2));
                task.setTaskDetail(cursor.getString(3));
                // Adding taswk to list
                taskList.add(task);
            } while (cursor.moveToNext());
        }

        // return task list
        return taskList;
    }

    // code to update the single task
    public int updateTask(DataClass task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TASKNAME, task.getTaskName());
        values.put(KEY_DUE_DATE, task.getTaskDueDate());
        values.put(KEY_TASK_DETAIL, task.getTaskDetail());

        // updating row
        return db.update(TABLE_TASKS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(task.getId()) });
    }

    // Deleting single contact
    public void deleteContact(DataClass task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, KEY_ID + " = ?",
                new String[] { String.valueOf(task.getId()) });
        db.close();

    }

    // Getting tasks Count
    public int getTasksCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TASKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
