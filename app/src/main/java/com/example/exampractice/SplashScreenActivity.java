package com.example.exampractice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);


        SharedPreferences.Editor smEditor =  getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE).edit();
        smEditor.putString("name","gurpinder Singh");
        smEditor.apply();


        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();

        timer.schedule(task,2000);






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}