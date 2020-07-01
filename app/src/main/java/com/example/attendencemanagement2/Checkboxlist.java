package com.example.attendencemanagement2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import Model.Course;

public class Checkboxlist extends BaseAdapter {
    private List<Course> list;

    public Checkboxlist(List<Course> list) {
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
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customlistview,null);
        TextView tcode=v.findViewById(R.id.subjectCode_change);
        TextView tname=v.findViewById(R.id.custom_course_name_change);
        Course course=list.get(i);
        tcode.setText(course.getCourseCode());
        tname.setText(course.getCourseName());
        return v;
    }
}
