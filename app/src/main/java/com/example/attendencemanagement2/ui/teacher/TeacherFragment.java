package com.example.attendencemanagement2.ui.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import Databases.Database;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.attendencemanagement2.CourseAdd;
import com.example.attendencemanagement2.R;
import com.example.attendencemanagement2.ui.student.StudentViewModel;

public class TeacherFragment extends Fragment  {
    private TeacherViewModel teacherViewModel;
    ListView teacherlistView;
    String value[];
    Database database;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_teacher,container,false);
        teacherlistView=view.findViewById(R.id.listview_teacher);
        database=new Database(getContext());

       // teacherlistView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,value));


        return view;


    }
}
/* teacherViewModel =
                    ViewModelProviders.of(this).get(TeacherViewModel.class);
            View root = inflater.inflate(R.layout.fragment_teacher, container, false);
            final TextView textView = root.findViewById(R.id.text_home);
            teacherViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
            return root;*/