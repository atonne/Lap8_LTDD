package com.example.lap07_b_roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvName;
    private NameAdapter nameAdapter;
    private ArrayList<String> nameArrayList;
//    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvName = findViewById(R.id.rcvName);

        nameArrayList = new ArrayList<>();
//        nameArrayList = db.get
        nameAdapter = new NameAdapter(this, nameArrayList);

        rcvName.setAdapter(nameAdapter);
        rcvName.setLayoutManager(new LinearLayoutManager(this));
    }
}