package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnProfile_Click(View v) {startActivity(new Intent(this, Profile.class));}
    public void btnSingIn_Click(View v){startActivity(new Intent(this, MainActivity.class));}
    public void tvRegister_Click(View v) {startActivity(new Intent(this, Registration.class));}
}