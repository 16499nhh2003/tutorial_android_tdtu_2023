package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // declare widget
    RecyclerView recyclerView;
    ArrayList<Item> dataSource;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  mapping xml and java
        this.recyclerView = this.findViewById(R.id.recyclerView);

        this.dataSource = new ArrayList<Item>();
        this.dataSource.add(new Item("Apple"));
        this.dataSource.add(new Item("Samsung"));
        this.dataSource.add(new Item("nokia"));
        this.dataSource.add(new Item("Oppo"));

        this.adapter = new CustomAdapter(this, dataSource);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.game_menu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //handle item selection
        int id = item.getItemId();
        if (id == R.id.deleteAll){
            this.dataSource.clear();
            this.adapter.notifyDataSetChanged();
        }
        else if(id == R.id.deleteSelected){
            this.dataSource.removeIf(item1 -> item1.getCheckBox());
            this.adapter.notifyDataSetChanged();
            for(Item item1 : this.dataSource){
                if(item1.getCheckBox()){
                    item1.setItemCheck(false);
                }
            }
        }
        else if( id == R.id.uncheckAll){
            for(Item item1 : this.dataSource){
                if(item1.getCheckBox()){
                    item1.setItemCheck(false);
                }
            }
        }
        else if(id == R.id.checkAll){
            for(Item i : this.dataSource) {
                if(!i.getCheckBox()) {
                    i.setItemCheck(true);
                }
            }
        }
        return  super.onOptionsItemSelected(item);
    }
}