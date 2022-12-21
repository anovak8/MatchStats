package com.example.newstar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

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
    private Button golDomaci;
    private int gol_domaci = 0;
    private Button golGosti;
    private int gol_gosti;
    LottieAnimationView zoga;
    private int i = 0;
    private int zacetna_posest = 50;
    private int trenutna_domaci = 50;
    private int trenutna_gosti = 50;
    private ProgressBar posest;
    private Button posestDomaci;
    private Button posestGosti;
    private Button pavza;
    private Button konec;
    DBHelperFinal DB;


    public abstract class DoubleClickListener implements View.OnClickListener {
        private static final long DEFAULT_QUALIFICATION_SPAN = 200;
        private boolean isSingleEvent;
        private long doubleClickQualificationSpanInMillis;
        private long timestampLastClick;
        private Handler handler;
        private Runnable runnable;

        public DoubleClickListener() {
            doubleClickQualificationSpanInMillis = DEFAULT_QUALIFICATION_SPAN;
            timestampLastClick = 0;
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (isSingleEvent) {
                        onSingleClick();
                    }
                }
            };
        }

        @Override
        public void onClick(View v) {
            if((SystemClock.elapsedRealtime() - timestampLastClick) < doubleClickQualificationSpanInMillis) {
                isSingleEvent = false;
                handler.removeCallbacks(runnable);
                onDoubleClick();
                return;
            }

            isSingleEvent = true;
            handler.postDelayed(runnable, DEFAULT_QUALIFICATION_SPAN);
            timestampLastClick = SystemClock.elapsedRealtime();
        }

        public abstract void onDoubleClick();
        public abstract void onSingleClick();
    }

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

        strelDomaci.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");

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
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });

        strelGosti.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
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
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });

        //kartoni

        rumeniDomaci = findViewById(R.id.rmD);

        rumeniDomaci.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                rumeni_domaci = rumeni_domaci + 1;
                rumeniDomaci.setText(String.valueOf(rumeni_domaci));

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });
        rumeniGosti = findViewById(R.id.rmG);

        rumeniGosti.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                rumeni_gosti = rumeni_gosti + 1;
                rumeniGosti.setText(String.valueOf(rumeni_gosti));

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });
        rdeciDomaci = findViewById(R.id.rD);

        rdeciDomaci.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                rdeci_domaci = rdeci_domaci + 1;
                rdeciDomaci.setText(String.valueOf(rdeci_domaci));

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });
        rdeciGosti = findViewById(R.id.rG);

        rdeciGosti.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                rdeci_gosti = rdeci_gosti + 1;
                rdeciGosti.setText(String.valueOf(rdeci_gosti));

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });

        //gol

        golDomaci = findViewById(R.id.golDomaci);
        zoga=findViewById(R.id.zoga);
        zoga.loop(false);
        golDomaci.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                if (i == 0){
                    zoga.playAnimation();
                    gol_domaci += 1;
                    golDomaci.setText(String.valueOf(gol_domaci));
                }

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });

        golGosti = findViewById(R.id.golGosti);
        zoga=findViewById(R.id.zoga);
        zoga.loop(false);
        golGosti.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick() {
                Log.i("onClick", "double");
                if (i == 0){
                    zoga.playAnimation();
                    gol_gosti += 1;
                    golGosti.setText(String.valueOf(gol_gosti));
                }

            }
            @Override
            public void onSingleClick() {
                Log.i("onClick", "single");
            }
        });

        //progress
        posest =findViewById(R.id.posest);
        posestDomaci = findViewById(R.id.posestDomaci);
        posestGosti = findViewById(R.id.posestGosti);

        final CountDownTimer countDownTimerDomaci = new CountDownTimer(100*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(trenutna_domaci < 100){
                    trenutna_gosti -= 1;
                    trenutna_domaci +=1;
                }
                posestDomaci.setText(String.valueOf(trenutna_domaci) + " %");
                posestGosti.setText(String.valueOf(trenutna_gosti) + " %");
                zacetna_posest = zacetna_posest + 1;
                posest.setProgress(zacetna_posest);
                posest.setMax(100);



            }

            @Override
            public void onFinish() {

            }
        };

        final CountDownTimer countDownTimerGosti = new CountDownTimer(100*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(trenutna_gosti < 100){
                    trenutna_gosti += 1;
                    trenutna_domaci -=1;
                }
                posestDomaci.setText(String.valueOf(trenutna_domaci) + " %");
                posestGosti.setText(String.valueOf(trenutna_gosti) + " %");
                zacetna_posest = zacetna_posest - 1;
                posest.setProgress(zacetna_posest);
                posest.setMax(100);



            }

            @Override
            public void onFinish() {

            }
        };

        pavza = findViewById(R.id.pavza);
        pavza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimerDomaci.cancel();
                countDownTimerGosti.cancel();
            }
        });

        posestGosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countDownTimerDomaci.cancel();
                countDownTimerGosti.start();
            }
        });

        posestDomaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countDownTimerGosti.cancel();
                countDownTimerDomaci.start();
            }
        });

        //zakljuck

        /*private int streli = 0;
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
    private Button golDomaci;
    private int gol_domaci = 0;
    private Button golGosti;
    private int gol_gosti;
    LottieAnimationView zoga;
    private int i = 0;
    private int zacetna_posest = 50;
    private int trenutna_domaci = 50;
    private int trenutna_gosti = 50;
    private ProgressBar posest;
    private Button posestDomaci;
    private Button posestGosti;
    private Button pavza;
    private Button konec;
    domaci
    gostujoci

         */

        DB = new DBHelperFinal(this);

        konec = findViewById(R.id.konec);
        konec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String domaciTXT = domaci.getText().toString().trim();
                String gostiTXT = gostujoci.getText().toString();
                int gol_domaciTXT = gol_domaci;
                int gol_gostiTXT = gol_gosti;
                int rumeni_domaciTXT = rumeni_domaci;
                int rumeni_gostiTXT = rumeni_gosti;
                int rdeci_domaciTXT = rdeci_domaci;
                int rdeci_gostiTXT = rdeci_gosti;
                int streli_domaciTXT = streli_domaci;
                int streli_gostiTXT = streli_gosti;
                int trenutna_domaciTXT = trenutna_domaci;
                int trenutna_gostiTXT = trenutna_gosti;

                Boolean checkinsertdata = DB.insertuserdata(domaciTXT,gostiTXT,gol_domaciTXT,gol_gostiTXT,rumeni_domaciTXT,rumeni_gostiTXT,rdeci_domaciTXT,rdeci_gostiTXT,streli_domaciTXT,streli_gostiTXT,trenutna_domaciTXT,trenutna_gostiTXT);
                if(checkinsertdata == true){
                    Toast.makeText(StatsActivity.this,"Failed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(StatsActivity.this, "Added Successfully!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        konec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StatsActivity.this, History.class);
                startActivity(i);
            }
        });


    }

}