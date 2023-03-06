package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.View;

public class Onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
    }

    public void btnEnter_Click (View v) {startActivity(new Intent(this, Login.class));}
    public void tvRegistration_Click (View v)  {startActivity(new Intent(this, Registration.class));}
}