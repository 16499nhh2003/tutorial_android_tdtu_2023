package com.example.lab5;

import android.content.Context;
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

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        CheckBox checkBox;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            this.checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
    Context context;
    List<Item> dataSource;
    public CustomAdapter(Context context , List<Item> items){
        this.context = context;
        this.dataSource = items;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context1);

        //inflate the custom layout
        View root = layoutInflater.inflate(R.layout.layout_one_item_exercise1 , parent, false);

        //return view holder instance
        MyHolder viewHolder = new MyHolder(root);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        // get the data model based on position
        Item item = dataSource.get(position);

        holder.imageView.setImageResource(R.drawable.baseline_phone_android_24);
        holder.textView.setText(item.getName());
        item.setCheckBox(holder.checkBox);
    }

    @Override
    public int getItemCount() {
        return this.dataSource.size();
    }
}
