package com.example.newstar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
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

    }

}