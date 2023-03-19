package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.view.View;

public class Onboarding extends AppCompatActivity {

    public static String image;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        SharedPreferences prefs = this.getSharedPreferences(
                "Date", Context.MODE_PRIVATE);
        if(prefs != null)
        {
            if(!prefs.getString("NickName", "").equals(""))
            {
                image = prefs.getString("image", "");
                name = prefs.getString("Name", "");
                startActivity(new Intent(this, MainPage.class));
            }
        }
    }

    public void btnEnter_Click (View v) {startActivity(new Intent(this, Login.class));}
    public void tvRegistration_Click (View v)  {startActivity(new Intent(this, Registration.class));}
}