package com.ahmed.salah.kingsoftheoldworld;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.margaritov.preference.colorpicker.ColorPickerDialog;

public class Splash extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo=findViewById(R.id.imageView);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.splash);
        logo.startAnimation(animation);




        final Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    Thread.sleep(3000);
                    Intent intent=new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        thread.start();




    }
}
