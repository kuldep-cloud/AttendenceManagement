package com.example.attendencemanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Spinner spinner_loginType;
    String spinner_Login[];
    TextInputLayout username_editText, password_editText;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username_editText = findViewById(R.id.text_input_username);
        password_editText = findViewById(R.id.text_input_password);
        loginButton = findViewById(R.id.login_button);
        spinner_loginType = findViewById(R.id.spinner_logintype);
        spinner_Login = getResources().getStringArray(R.array.logintype);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinner_Login);
        spinner_loginType.setAdapter(adapter);


    }

    public void opertionlogin(View view) {


        validateEmailPassword();

    }

    private void validateEmailPassword() {
        String email = username_editText.getEditText().getText().toString();
        String password = password_editText.getEditText().getText().toString();
        int index = spinner_loginType.getSelectedItemPosition();

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (email.equals("admin") && password.equals("password"))
            {
                if(index==0)
                {
                    Toast.makeText(this, "Please Select Login Type", Toast.LENGTH_SHORT).show();
                }
                else if(index==1)
                {
                    startActivity(new Intent(MainActivity.this,Admin_Activity2.class));
                }
                else if(index==2)
                {
                    Toast.makeText(this, "you are teacher. you cant login with admin username and password", Toast.LENGTH_SHORT).show();
                }
                else if(index==3)
                {
                    Toast.makeText(this, "you are student. you cant login with admin username and password", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "username and Password doesn't match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}