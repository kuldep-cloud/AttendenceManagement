package com.example.attendencemanagement2;

import Databases.Database;
import Model.Course;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Student_Activity extends AppCompatActivity {
    EditText firstname_Editext,roll_number_edittext,contact_number_edittext,email_id_edittext;
    ListView listView;
    Button addstudent_btn,addbtn2;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student_);
        firstname_Editext=findViewById(R.id.firstname_edittext);
        roll_number_edittext=findViewById(R.id.rollnumber_edittext);
        contact_number_edittext=findViewById(R.id.contactnumber_edittext);
        email_id_edittext=findViewById(R.id.emailid_edittext);
        listView=findViewById(R.id.course_list2);
        addstudent_btn=findViewById(R.id.addstudent);
        database=new Database(this);

        List<Course> list=database.getAllCourseNameCode();
        if(list.size()>0)
        {
            listView.setAdapter(new Checkboxlist(list));

        }
        else
        {
            Toast.makeText(Student_Activity.this, "sorry there is no course ", Toast.LENGTH_SHORT).show();
        }

    }

    public void addstudentbtn(View view) {
        String firstname=firstname_Editext.getText().toString();
        String lastname=roll_number_edittext.getText().toString();
        String contactnumber=contact_number_edittext.getText().toString();
        String emailid=email_id_edittext.getText().toString();
        validatefirstname(firstname);
        validatelastname(lastname);
        validatecontactnumber(contactnumber);
        validateEmailid(emailid);





    }

    private void validatelastname(String lastname) {
    }

    private void validatefirstname(String firstname) {
    }

    private void validatecontactnumber(String contactnumber) {
    }

    private void validateEmailid(String emailid) {
    }




}