package com.example.attendencemanagement2;

import Databases.Database;
import Model.Course;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Teacher_Activity extends AppCompatActivity {
    Button addcourseButton;
    Database database;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        addcourseButton=findViewById(R.id.add_couse_btn);
        listView=findViewById(R.id.addcouse_listview);
        database=new Database(this);

    }
    public void fetchdata(View view) {
        List<Course> list=database.getAllCourseNameCode();
        if(list.size()>0)
        {
            listView.setAdapter(new CourseList(list));

        }
        else
        {
            Toast.makeText(this, "sorry there is no course ", Toast.LENGTH_SHORT).show();
        }
    }
}