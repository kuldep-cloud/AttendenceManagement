package com.example.attendencemanagement2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Model.Course;

public class CourseList extends BaseAdapter {
    private List<Course> list;
    public CourseList(List<Course> list)
    {
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.courselist,null);
        TextView tcode=v.findViewById(R.id.course_code_change);
        TextView tname=v.findViewById(R.id.course_name_change2);
        Course course=list.get(i);
        tcode.setText(course.getCourseCode());
        tname.setText(course.getCourseName());
        return v;
    }
}
