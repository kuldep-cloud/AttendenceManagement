package com.example.attendencemanagement2.ui.teacher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeacherViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TeacherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is teacher fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}