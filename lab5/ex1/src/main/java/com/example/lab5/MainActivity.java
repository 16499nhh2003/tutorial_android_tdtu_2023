package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomDialog.DialogListener {

    // declare widget
    RecyclerView recyclerView;
    ArrayList<Item> dataSource;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = this.findViewById(R.id.recyclerView);

        this.dataSource = new ArrayList<Item>();
        this.dataSource.add(new Item("Apple", false));
        this.dataSource.add(new Item("Samsung", false));
        this.dataSource.add(new Item("nokia", false));
        this.dataSource.add(new Item("Oppo", false));

        this.adapter = new CustomAdapter(this, dataSource);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL));
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.game_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.deleteAll) {
            openDialog(id);
        } else if (id == R.id.deleteSelected) {
            openDialog(id);
        } else if (id == R.id.uncheckAll) {
            for (Item item1 : this.dataSource) {
                if (item1.isChecked()) {
                    item1.setChecked(false);
                }
            }
            this.adapter.notifyDataSetChanged();
        } else if (id == R.id.checkAll) {
            for (Item i : this.dataSource) {
                i.setChecked(true);
            }
            this.adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog(int id) {
        CustomDialog customDialog = new CustomDialog(id);
        customDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void onDialogPositiveClick(int b) {
        if (b == R.id.deleteAll) {
            this.dataSource.clear();
            this.adapter.notifyDataSetChanged();
        }
        if (b == R.id.deleteSelected) {
            this.dataSource.removeIf(Item::isChecked);
            for (Item item1 : this.dataSource) {
                if (item1.isChecked()) {
                    item1.setChecked(false);
                }
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDialogNegativeClick(int b) {

    }
}