package com.example.exercise2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DialogCustom.NoticeDialogListener {

    ArrayList<Item> items;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<Item>();

        SimpleDateFormat dmyFormat = new SimpleDateFormat("MM/dd/yyyy k:m");
        items.add(new Item("1", "C104", dmyFormat.format(new Date()), true));
        items.add(new Item("2", "C102", dmyFormat.format(new Date()), true));
        items.add(new Item("3", "C104", dmyFormat.format(new Date()), true));
        items.add(new Item("4", "C102", dmyFormat.format(new Date()), false));
        items.add(new Item("5", "C104", dmyFormat.format(new Date()), true));
        items.add(new Item("6", "C102", dmyFormat.format(new Date()), true));


        RecyclerView recyclerView = findViewById(R.id.recycleView);
        adapter = new MyAdapter(MainActivity.this, items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        registerForContextMenu(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.mySwitch);
        menuItem.setActionView(R.layout.switch_layout);

        SwitchCompat allSwitch = menuItem.getActionView().findViewById(R.id.layout_switch);
        allSwitch.setChecked(true);
        allSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnAdd) {
            this.startActivityForResult(new Intent(this, MainActivity2.class), 1);
            return true;
        }
        if (item.getItemId() == R.id.btnRemoveALL) {
            confirmDelete(R.id.btnRemoveALL);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = item.getGroupId();
        switch (item.getItemId()) {
            case MyAdapter.DELETE: {
                items.remove(items.get(position));
                adapter.notifyItemRemoved(position);
                return true;
            }
            case MyAdapter.EDIT: {
                return false;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void confirmDelete(int id) {
        DialogCustom dialogCustom = new DialogCustom(id);
        dialogCustom.show(getSupportFragmentManager(), "delete");
    }

    @Override
    public void onDialogPositiveClick(int dialog) {
        this.items.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            Log.i("adđ" , "123");
            this.items.add(new Item(data.getStringExtra("title"), data.getStringExtra("place"),
                    data.getStringExtra("date") + data.getStringExtra("time"), true));
//            this.adapter.notifyItemInserted(this.items.size());
//            this.adapter.notifyItemRangeChanged(this.items.size(), 1);
            this.adapter.notifyDataSetChanged();
        }
    }
}
