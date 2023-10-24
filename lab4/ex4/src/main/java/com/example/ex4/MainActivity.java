package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recycleView);

        items = new ArrayList<Item>();
        // initialize
        for (int i = 1; i <= 100; i++) {
            items.add(new Item("PC" + i ,false));
        }

        MyAdapter adapter = new MyAdapter(this, items);

        rvContacts.setAdapter(adapter);

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL);
        rvContacts.setLayoutManager(gridLayoutManager);
    }
}