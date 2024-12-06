package com.example.exampractice;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable lightAnimation;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.title);
        String titleString = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE).getString("name","demo");
        title.setText(titleString);
        MaterialToolbar toolbar = findViewById(R.id.materialToolbar3);

//        toolbar.setNavigationIcon(R.drawable.rounded_123_24);
        setSupportActionBar(toolbar);



        Objects.requireNonNull(getSupportActionBar()).setTitle(null);


        ImageView img = findViewById(R.id.imageView2);

        img.setBackgroundResource(R.drawable.animation);
        lightAnimation = (AnimationDrawable) img.getBackground();
        button  = findViewById(R.id.button);
        button.setOnClickListener(this::handleOnClick);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lightAnimation.stop();
    }



    public void handleOnClick(View view){
        if(lightAnimation.isRunning()){
            lightAnimation.stop();
        }
        else{
            lightAnimation.start();
        }

    }
}