package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Profile extends AppCompatActivity {

    ImageView image;
    TextView name;

    public void onClickMain(View v)
    {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void onClickMenu(View v)
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void onClickLogin(View v)
    {
        SharedPreferences sahrpr = getSharedPreferences( "Date", Context.MODE_PRIVATE);
        sahrpr.edit().putString("Avatar", "").apply();
        sahrpr.edit().putString("NickName", "").apply();

        startActivity(new Intent(this, Login.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        image = findViewById(R.id.profile_img);
        name = findViewById(R.id.textView2);
        name.setText(Onboarding.name);
    }
}