package com.example.exercise2;

import android.app.Activity;
import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHoder> {
    public static final int DELETE = 1;
    public static final int EDIT = 2;
    ArrayList<Item> items;
    Context context;

    public class MyHoder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView tvName, tvNameRoom, tvDate;
        Switch switch1;
        LinearLayout linearLayout;

        public MyHoder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvNameRoom = (TextView) itemView.findViewById(R.id.tvNameRoom);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            switch1 = (Switch) itemView.findViewById(R.id.switch1);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.itemGroup);
            linearLayout.setOnCreateContextMenuListener(this);
        }

        public void bindData(int pos, Item item) {
            tvName.setText(item.getTitle());
            tvNameRoom.setText(item.getNameRoom());
            tvDate.setText(item.getDate());
            switch1.setChecked(item.isEnable());
            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch1.setChecked(isChecked);
                    item.setEnable(isChecked);
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), DELETE, 0, "Delete");
            menu.add(this.getAdapterPosition(), EDIT, 1, "Edit");
        }
    }

    public Item getItem(int pos) {
        return items.get(pos);
    }

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item, parent, false);
        return new MyHoder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        holder.bindData(position, getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
