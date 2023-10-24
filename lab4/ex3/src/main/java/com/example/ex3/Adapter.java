package com.example.ex3;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
    private Context context;
    private List<Item> items;
    public Adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get data model based on position
        Item item = items.get(position);

        //render textview
        holder.textView.setText(item.getTitle());
        // render checkbox
        holder.checkBox.setChecked(item.isCheck());
        // handle checkbox
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCheck(holder.checkBox.isChecked());
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}
