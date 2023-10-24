package com.example.lab5;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {

    public static class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }

        public void bindData(int pos, Item item) {
            imageView.setImageResource(R.drawable.baseline_phone_android_24);
            textView.setText(item.getName());
            checkBox.setChecked(item.isChecked());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.setChecked(!item.isChecked());
                }
            });
        }
    }

    Context context;
    List<Item> dataSource;

    public CustomAdapter(Context context, List<Item> items) {
        this.context = context;
        this.dataSource = items;
    }

    public Item getItem(int pos) {
        return dataSource.get(pos);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item_exercise1, parent, false);
        return new MyHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bindData(position, getItem(position));

    }

    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }
}
