package com.example.ex5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students = new ArrayList<>();
    static final int studentNumberModify = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Total user : " +  students.size());

        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startAdd = students.size() + 1;
                int count = studentNumberModify;
                while (count != 0) {
                    String name = "User " + startAdd;
                    String email = "user" + startAdd + "gmail.com";
                    students.add(new Student(name, email));
                    textView.setText("Total user : " +  students.size());
                    studentAdapter.notifyDataSetChanged();
                    startAdd++;
                    count--;
                }
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startDelete = students.size() - 1;
                int count = studentNumberModify;
                int itemCountDeleted = Math.min(count, students.size());

                if(students.isEmpty()){
                    Toast.makeText(MainActivity.this , "List of users is empty" , Toast.LENGTH_LONG).show();
                }
                while (count > 0 && !students.isEmpty()) {
                    students.remove(students.size() - 1);
                    textView.setText("Total user : " +  students.size());
                    studentAdapter.notifyDataSetChanged();
                    count--;
                }

            }
        });
    }


}