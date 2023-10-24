package com.example.ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnRemoveAll, btnRemoveSelected;
    Adapter adapter;
    ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRemoveAll = findViewById(R.id.btnRemoveAll);
        btnRemoveSelected = findViewById(R.id.btnRemoveSelected);

        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        items = new ArrayList<Item>();
        items.add(new Item("Apple" , false));
        items.add(new Item("Samsung" , false));
        items.add(new Item("Nokia" , false));
        items.add(new Item("Oppo" , false));

        adapter = new Adapter(this , items);
        LinearLayoutManager layoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        btnRemoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.clear();
                adapter.notifyDataSetChanged();
            }
        });

        btnRemoveSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Item> items1 =  new ArrayList<Item>();
                for (Item item : items){
                    if (item.isCheck()){
                        items1.add(item);
                    }
                }
                items.removeAll(items1);
                for(Item item : items) {
                    Log.i("selected" , item.getTitle() + item.isCheck());
                }
                adapter.notifyDataSetChanged();
            }
        });

    }
}