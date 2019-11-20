package com.ahmed.salah.kingsoftheoldworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    AdView adView;

    MainAdapter mainAdapter;
    List<KingsName>kingsNames=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ////////Ads//////////////
        MobileAds.initialize(this,"ca-app-pub-7728492295600846~4489843387");
        adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        ////////////////////////



        /////////////////// start toolbar /////////////////////////////////////////
        toolbar=(Toolbar)findViewById(R.id.mantoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ملوك العالم القديم");
        /////////////////// end toolbar /////////////////////////////////////////


        /////////////////// start Set Data /////////////////////////////////////////
        String recData[]={

                        "الاسكندر الاكبر",
                        "تحتمس الثالث",
                        "يوليوس قيصر",
                        "كسرى الأول",
                        "رمسيس الثاني",
                        "ماسينسيا",
                        "أشور بانيبال",
                        "زنوبيا",
                        "أغسطس قيصر",
                        "الملك مينا",
                        "تشين شي هوانج",
                        "سرجون الأكدي",
                        "حمورابي","أشوكا",
                        "ليونيداس","ترجان",
                        "زوسر","بيروس الإبيري",
                        "كورش الكبير",
                        "نارام سين",
                        "كرب ايل وتر",
                        "شاندرا جوبتا الأول",
                        "الحارث الرابع",
                        "موتشيه ثيان ",
                /////////////new//////////////
                        "كليوباترا",
                        "نبوخذ نصر الثانى",
                        "تساو تساو",
                        "يوغرطة",
                        "أور نمو",
                        "توت عنخ آمون",
                        "نيرون",
                        "آشور ناصر بال الثانى",
                        "أخناتون",
                        "داريوش الأول",
                        "حانون القرطاجى",
                        "غاوزو من هان",
                        "تيبيريوس",
                        "يوبا الأول",
                        "ديسيبالوس",
                        "بوريبيستا",
                        "الملك بورس",
                        "لوغال زاغيسى",
                        "ياريم-ليم الأول",
                        "توكولتى نينوتا الأول",
                        "شلمنصر الثالث",
                        "ميثراداتس السادس",
                        "كوديا",
                        "سابور الثانى",
                        "سنحاريب",
                        "بوكوس"

        };

        int image[]={

                        R.drawable.askandr,
                        R.drawable.tohotmos,
                        R.drawable.ulios,
                        R.drawable.kesraawel,
                        R.drawable.ramsestant,
                        R.drawable.masinsia,
                        R.drawable.ashor,
                        R.drawable.zonb,
                        R.drawable.oostos,
                        R.drawable.mina,
                        R.drawable.tshen,
                        R.drawable.srgon,
                        R.drawable.homara,
                        R.drawable.ashoka,
                        R.drawable.leonidas,
                        R.drawable.tragan,
                        R.drawable.sosar,
                        R.drawable.piros,
                        R.drawable.korsh,
                        R.drawable.naram,
                        R.drawable.karb,
                        R.drawable.shandra,
                        R.drawable.hares,
                        R.drawable.sian,
                /////////////new//////////////
                        R.drawable.cleopatra3,
                        R.drawable.nob5z,
                        R.drawable.cao_cao_scth,
                        R.drawable.jugurt10,
                        R.drawable.ornomo,
                        R.drawable.tot,
                        R.drawable.neron,
                        R.drawable.ashor2,
                        R.drawable.e5naton,
                        R.drawable.dareosh,
                        R.drawable.hanon,
                        R.drawable.aozo,
                        R.drawable.tiberius_palermo,
                        R.drawable.juba_i,
                        R.drawable.desib,
                        R.drawable.burebista,
                        R.drawable.surrender,
                        R.drawable.loal,
                        R.drawable.yarem,
                        R.drawable.yokolty,
                        R.drawable.shlmansr,
                        R.drawable.mesra,
                        R.drawable.kodia,
                        R.drawable.head,
                        R.drawable.sennacheribprofile,
                        R.drawable.bocchus

        };

        String html []={


                        getString(R.string.askandr),
                        getString(R.string.to7otmos),
                        getString(R.string.uolios),
                        getString(R.string.kesraawel),
                        getString(R.string.ramsestant),
                        getString(R.string.masinsia),
                        getString(R.string.ashor),
                        getString(R.string.zonb),
                        getString(R.string.oostos),
                        getString(R.string.mina),
                        getString(R.string.tshin),
                        getString(R.string.srgon),
                        getString(R.string.homarabay),
                        getString(R.string.ashoka),
                        getString(R.string.lionedas),
                        getString(R.string.torgan),
                        getString(R.string.sosar),
                        getString(R.string.pairos),
                        getString(R.string.korsh),
                        getString(R.string.naram),
                        getString(R.string.kreb),
                        getString(R.string.shandra),
                        getString(R.string.elhars),
                        getString(R.string.sian),
                getString(R.string.cleopatra),
                getString(R.string.nob5z),
                getString(R.string.cao_cao_scth),
                getString(R.string.jugurt10),
                getString(R.string.ornomo),
                getString(R.string.tot),
                getString(R.string.neron),
                getString(R.string.ashor2),
                getString(R.string.e5naton),
                getString(R.string.dareosh),
                getString(R.string.hanon),
                getString(R.string.aozo),
                getString(R.string.tiberius_palermo),
                getString(R.string.juba_i),
                getString(R.string.desib),
                getString(R.string.burebista),
                getString(R.string.surrender),
                getString(R.string.loal),
                getString(R.string.yarem),
                getString(R.string.yokolty),
                getString(R.string.shlmansr),
                getString(R.string.mesra),
                getString(R.string.kodia),
                getString(R.string.head),
                getString(R.string.sennacheribprofile),
                getString(R.string.bocchus),
        };

        for (int i=0;i<recData.length;i++){

                        KingsName kingsName=new KingsName(recData[i],image[i],html[i]);
                        kingsNames.add(kingsName);
        }

        /////////////// end Set Data //////////////////////////////////////////


        ////////////////start RecyclerView /////////////////////////////////////////
        recyclerView=(RecyclerView)findViewById(R.id.mainRec);
        mainAdapter=new MainAdapter(this,kingsNames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
        /////////////////// end RecyclerView /////////////////////////////////////////
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==R.id.exit){

            finish();

        }

        if (item.getItemId()==R.id.about){

            Intent intent=new Intent(MainActivity.this,About.class);
            startActivity(intent);

        }
        if (item.getItemId()==R.id.share){



            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            String shareName="تطبيق ملوك العالم القديم";
            String link="https://play.google.com/store/apps/details?id=com.ahmed.salah.kingsoftheoldworld";

            share.putExtra(Intent.EXTRA_TEXT,shareName +"\n"+ link);
            startActivity(share);




        }

        return super.onOptionsItemSelected(item);
    }
}
