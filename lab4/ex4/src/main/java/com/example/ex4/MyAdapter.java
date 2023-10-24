package com.example.ex4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Item> items;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

        public void bindData(int position, Item item) {
            textView.setText(item.getName());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(item.isSelected()){
                        Toast.makeText(itemView.getContext(),"On " +  item.getName(),Toast.LENGTH_LONG ).show();
                        item.setSelected(false);
                    }
                    else{
                        Toast.makeText(itemView.getContext(), "Off" +  item.getName(),Toast.LENGTH_LONG ).show();
                        item.setSelected(true);
                    }

                }
            });
        }
    }

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    public Item getItem(int position) {
        return items.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position, getItem(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
