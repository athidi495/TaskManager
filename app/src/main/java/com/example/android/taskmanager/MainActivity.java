package com.example.android.taskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<DataClass> list = DataClass.getData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DataBaseHandler db = new DataBaseHandler(this);

    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
