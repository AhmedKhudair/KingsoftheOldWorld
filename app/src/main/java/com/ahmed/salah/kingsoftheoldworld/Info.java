package com.ahmed.salah.kingsoftheoldworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import net.margaritov.preference.colorpicker.ColorPickerDialog;

public class Info extends AppCompatActivity {


    Toolbar toolbar;
    TextView content;
    ImageView imageView;
    int size=15;
    int maxSize=25;
    AdView adViewInfo;
    int minSize=10;
    ColorPickerDialog pickerDialog;
    int color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



        toolbar=(Toolbar)findViewById(R.id.infoToolbar);
        content=(TextView) findViewById(R.id.contentTxt);
        imageView=(ImageView)findViewById(R.id.infoImg);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        ////////Ads//////////////
        MobileAds.initialize(this,"ca-app-pub-7728492295600846~4489843387");
        adViewInfo=findViewById(R.id.adViewInfo);
        AdRequest adRequest=new AdRequest.Builder().build();
        adViewInfo.loadAd(adRequest);

        ////////////////////////



        Intent intent=getIntent();

        String NAME=intent.getStringExtra("name");
        getSupportActionBar().setTitle(NAME);

        String CONTENT=intent.getStringExtra("content");
        content.setText(CONTENT);



        int img=intent.getIntExtra("img",0);
        imageView.setImageResource(img);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zoom,menu);
        getMenuInflater().inflate(R.menu.font_style,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){

            finish();


        }

        if (item.getItemId()==R.id.in){

            if(size==maxSize){

                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setMessage("لا يمكن التكبير اكثر من ذلك");
                dialog.setCancelable(false);
                dialog.create();
                dialog.show();
            }
            else {

                size++;
                content.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
            }





        }

        if (item.getItemId()==R.id.out){

            if(size==minSize){

                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setMessage("لا يمكن التصغير اكثر من ذلك");
                dialog.setCancelable(false);
                dialog.create();
                dialog.show();
            }

            else {

                size--;
                content.setTextSize(size);
            }



        }

        if (item.getItemId()==R.id.bold){


            content.setTypeface(content.getTypeface(), Typeface.BOLD);


        }

        if (item.getItemId()==R.id.normalfont){


            content.setTypeface(Typeface.DEFAULT);
        }

        if (item.getItemId()==R.id.color){

            color= Color.parseColor("#252220");
            pickerDialog=new ColorPickerDialog(Info.this,color);
            pickerDialog.setAlphaSliderVisible(true);
            pickerDialog.setTitle("اختار لون الخط");
            pickerDialog.setOnColorChangedListener(new ColorPickerDialog.OnColorChangedListener() {
                @Override
                public void onColorChanged(int i) {
                    color=i;
                    content.setTextColor(color);
                }
            });

            pickerDialog.show();

        }

        return super.onOptionsItemSelected(item);

    }



}
