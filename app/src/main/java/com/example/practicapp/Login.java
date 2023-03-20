package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    EditText Email;
    EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email = findViewById(R.id.edEmail);
        Password = findViewById(R.id.tvPassword);

        SharedPreferences prefs = this.getSharedPreferences("Date", Context.MODE_PRIVATE);
        if(prefs != null)
        {
            Email.setText(prefs.getString("Email", ""));
            Password.requestFocus();
        }
    }

    public void btnProfile_Click(View v) {startActivity(new Intent(this, Profile.class));}

    public void btnSingIn_Click(View v)
    {
        if(Email.getText().toString().equals("") || Password.getText().toString().equals(""))
        {
            Toast.makeText(Login.this, "Не все поля были заполнены", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Pattern p = Pattern.compile("@", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(Email.getText().toString());
            boolean b = m.find();
            if(b)
            {
                /*getLogin();*/
                startActivity(new Intent(this, MainPage.class));
            }
        }
    }

    public void tvRegister_Click(View v) {startActivity(new Intent(this, Registration.class));}

    private void getLogin()
    {
        String email = String.valueOf(Email.getText());
        String password = String.valueOf(Password.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        ModelUser modelSendUser = new ModelUser(email, password);
        Call<MaskUser> call = retrofitAPI.newUser(modelSendUser);
        call.enqueue(new Callback<MaskUser>() {
            @Override
            public void onResponse(Call<MaskUser> call, Response<MaskUser> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Login.this, "Пользователь не найден", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(response.body() != null)
                {
                    if(response.body().getToken() != null)
                    {
                        SharedPreferences prefs = getSharedPreferences( "Date", Context.MODE_PRIVATE);
                        prefs.edit().putString("Email", "" + email).apply();
                        prefs.edit().putString("image", "" + response.body().getAvatar()).apply();
                        prefs.edit().putString("Name", "" + response.body().getNickName()).apply();
                        Onboarding.image = response.body().getAvatar();
                        Onboarding.name = response.body().getNickName();
                        Intent intent = new Intent(Login.this, MainPage.class);
                        Bundle b = new Bundle();
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<MaskUser> call, Throwable t) {
                Toast.makeText(Login.this, "Ошибка:" + t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}