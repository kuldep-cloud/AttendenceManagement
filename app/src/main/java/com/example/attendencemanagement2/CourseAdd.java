package com.example.attendencemanagement2;

import Databases.Database;
import Model.Course;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CourseAdd extends AppCompatActivity {
    EditText courseName,courseCode;
    Button addcourseButton;
    Database database;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        courseCode=findViewById(R.id.couse_code);
        courseName=findViewById(R.id.couse_name);
        addcourseButton=findViewById(R.id.add_couse_btn);
        listView=findViewById(R.id.addcouse_listview);
        database=new Database(this);
        addcourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCourse();
            }
        });

    }

    private void AddCourse() {
        String coursecode=courseCode.getText().toString().toUpperCase();
        String coursename=courseName.getText().toString().toUpperCase();
       validateCourseCode(coursecode);
       validateCourseName(coursename);

        Course course=new Course();
        course.setCourseCode(coursecode);
        course.setCourseName(coursename);

        long t=database.insert(course);
        if(t>0){
            Toast.makeText(this, "Course Add Successfully", Toast.LENGTH_SHORT).show();
            courseCode.setText("");
            courseName.setText("");
        }
        else {
            Toast.makeText(this, "Course Add Failed", Toast.LENGTH_SHORT).show();
        }

    }

    private void validateCourseName(String coursename) {

        int u=0,l=0,s=0,n=0;

        for(int i=0;i<coursename.length();i++)
        {
            char ch=coursename.charAt(i);
            if(ch>='A' && ch<='Z')
                u++;
            else if(ch>='a' && ch<= 'z')
                l++;
            else if (ch>='0' && ch<='9')
                n++;
            else
                s++;
            if(coursename.isEmpty())
            {
                courseName.setError("Please Enter Course Name");
            }
            else if(s>0)
            {
                courseName.setError("Special charechter doesnt allow");
            }
            else if(n>0)
            {
                courseName.setError("Numerical not be Allow in name");
            }
            
        }
        
    }

    private void validateCourseCode(String coursecode) {

        int u=0,l=0,s=0,n=0;

        for(int i=0;i<coursecode.length();i++)
        {
            char ch=coursecode.charAt(i);
            if(ch>='A' && ch<='Z')
                u++;
            else if(ch>='a' && ch<= 'z')
                l++;
            else if (ch>='0' && ch<='9')
                n++;
            else
                s++;
        }

        if(coursecode.isEmpty())
        {
            courseCode.setError("Please Enter Course Name");
        }

        else if(coursecode.length()!=6 || coursecode.length()>6 )
        {
            courseCode.setError("This Course Code is not valid");
        }
        else if(s==1)
        {
            courseCode.setError("Special charechter doesnt allow");
        }
        else if(u>3)
        {
            courseCode.setError("Alphabet should not be more than 3");
        }
        else if(l>3)
        {
            courseCode.setError("Alphabet should not be more than 3");
        }
        else if(n>3)
        {
            courseCode.setError("numerical should not be more than 3");
        }
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