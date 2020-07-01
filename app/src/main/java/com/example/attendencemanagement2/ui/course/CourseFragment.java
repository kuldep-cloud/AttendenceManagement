package com.example.attendencemanagement2.ui.course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Databases.Database;
import Model.Course;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.attendencemanagement2.CourseAdd;
import com.example.attendencemanagement2.CourseList;
import com.example.attendencemanagement2.MainActivity;
import com.example.attendencemanagement2.R;

import java.util.List;

import static android.R.layout.simple_list_item_1;

public class CourseFragment extends Fragment {
    Button addcourseButton;
    Database database;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View root=inflater.inflate(R.layout.fragment_course, container, false);
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        addcourseButton=view.findViewById(R.id.show_add_couse_btn);
        listView=view.findViewById(R.id.addcouse_listview);
        database=new Database(getContext());
        addcourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Course> list=database.getAllCourseNameCode();
                if(list.size()>0)
                {
                    listView.setAdapter(new CourseList(list));

                }
                else
                {
                    Toast.makeText(getActivity(), "sorry there is no course ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
