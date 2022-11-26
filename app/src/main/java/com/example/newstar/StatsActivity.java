package com.example.newstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    private int streli = 0;
    private int progress = 0;
    private int streli_domaci = 0;
    private int streli_gosti = 0;
    private int rumeni_domaci = 0;
    private int rumeni_gosti = 0;
    private int rdeci_gosti = 0;
    private int rdeci_domaci = 0;
    private ProgressBar progressBarStreli;
    private Button strelDomaci;
    private Button strelGosti;
    private Button rumeniDomaci;
    private Button rumeniGosti;
    private Button rdeciGosti;
    private Button rdeciDomaci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);
        //imena ekip
        Bundle bundle = getIntent().getExtras();
        String Datum = bundle.getString("Datum");
        String home = bundle.getString("Home");
        String away = bundle.getString("Away");
        TextView datum = findViewById(R.id.datum);
        TextView domaci = findViewById(R.id.domaci);
        TextView gostujoci = findViewById(R.id.gostujoci);
        domaci.setText(home);
        datum.setText(Datum);
        gostujoci.setText(away);


        //streli
        progressBarStreli =findViewById(R.id.progressBar);
        strelDomaci = findViewById(R.id.domaciStreli);
        strelGosti = findViewById(R.id.gostiStreli);

        strelDomaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                streli_domaci = streli_domaci + 1;
                streli = streli_domaci + streli_gosti;
                //progress = progress + ((streli_domaci/streli)*100);
                if(streli_domaci == 1 && streli_gosti == 0){
                    progress = progress + 100;
                    progressBarStreli.setProgress(progress);
                }else{
                    progress = streli_domaci*100/streli;
                    progressBarStreli.setProgress(progress);
                    progressBarStreli.setMax(100);
                }

                strelDomaci.setText(String.valueOf(streli_domaci));

            }
        });



        strelGosti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                streli_gosti = streli_gosti + 1;
                streli = streli_domaci + streli_gosti;

                if(streli_gosti == 1 && streli_domaci == 0){
                    progress = progress + 0;
                    progressBarStreli.setProgress(progress);
                }else{
                    progress = streli_domaci*100/streli;
                    progressBarStreli.setProgress(progress);
                    progressBarStreli.setMax(100);
                }

                strelGosti.setText(String.valueOf(streli_gosti));

            }
        });

        //kartoni

        rumeniDomaci = findViewById(R.id.rmD);

        rumeniDomaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rumeni_domaci = rumeni_domaci + 1;
                rumeniDomaci.setText(String.valueOf(rumeni_domaci));

            }
        });
        rumeniGosti = findViewById(R.id.rmG);

        rumeniGosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rumeni_gosti = rumeni_gosti + 1;
                rumeniGosti.setText(String.valueOf(rumeni_gosti));

            }
        });
        rdeciDomaci = findViewById(R.id.rD);

        rdeciDomaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdeci_domaci = rdeci_domaci + 1;
                rdeciDomaci.setText(String.valueOf(rdeci_domaci));

            }
        });
        rdeciGosti = findViewById(R.id.rG);

        rdeciGosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdeci_gosti = rdeci_gosti + 1;
                rdeciGosti.setText(String.valueOf(rdeci_gosti));

            }
        });

    }


}