package com.example.attendencemanagement2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.attendencemanagement2.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_home,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout ls=view.findViewById(R.id.profile_id);
        LinearLayout lt=view.findViewById(R.id.id_teacher);
        LinearLayout lc=view.findViewById(R.id.id_course);
        LinearLayout la=view.findViewById(R.id.id_attendence);
        LinearLayout lse=view.findViewById(R.id.id_settings);
        LinearLayout ll=view.findViewById(R.id.id_logout);

        ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NavController navController=Navigation.findNavController(view);
               navController.navigate(R.id.action_nav_home_to_nav_student);
            }
        });
        lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController=Navigation.findNavController(view);
                navController.navigate(R.id.action_nav_home_to_nav_teacher);
            }
        });
        lc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController=Navigation.findNavController(view);
                navController.navigate(R.id.action_nav_home_to_nav_course);
            }
        });
        la.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController=Navigation.findNavController(view);
                navController.navigate(R.id.action_nav_home_to_nav_attendance);
            }
        });
        lse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController=Navigation.findNavController(view);
                navController.navigate(R.id.action_nav_home_to_nav_settings);
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController=Navigation.findNavController(view);
                navController.navigate(R.id.action_nav_home_to_nav_logout);
            }
        });



    }
}
