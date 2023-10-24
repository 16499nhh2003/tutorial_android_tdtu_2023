package com.example.ex5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }

        public void bindData(int pos, Student student) {
            tvName.setText(student.getName());
            tvEmail.setText(student.getEmail());
        }

    }

    private Context context;
    private ArrayList<Student> dataSources;

    public StudentAdapter(Context context, ArrayList<Student> dataSources) {
        this.context = context;
        this.dataSources = dataSources;
    }

    public Student getStudent(int pos) {
        return dataSources.get(pos);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position, getStudent(position));
    }

    @Override
    public int getItemCount() {
        return dataSources.size();
    }
}
