package com.example.newstar;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class new_game extends AppCompatActivity {
    //klubi za samoizpis, lahko se dodaja notri
    private static final String[] KLUBI = new String[]{
            "Maribor",
            "Olimpija",
            "Domžale",
            "Celje",
            "Mura",
            "Rudar Velenje",
            "Bravo",
            "Tabor Sežana",
            "Aluminij",
            "Triglav Kranj",
            "Termit Moravče",
            "Roltek Dob",
            "Kalcer Radomlje",
            "Zagorje"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        TextView dateTimeDisplay;
        Calendar calendar;
        SimpleDateFormat dateFormat;
        String date;

        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, KLUBI);
        editText.setAdapter(adapter);

        AutoCompleteTextView editTextAway = findViewById(R.id.actv1);
        ArrayAdapter<String> adapterAway = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, KLUBI);
        editTextAway.setAdapter(adapterAway);

        //datum
        dateTimeDisplay = (TextView)findViewById(R.id.editTextDate);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());
        dateTimeDisplay.setText(date);

        Button next = (Button) findViewById(R.id.submitTeams);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //čekiranje praznih vnosnih polj
                if( TextUtils.isEmpty(editTextAway.getText()) || TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(new_game.this, "Team names must be filled.", Toast.LENGTH_SHORT).show();
                }else if ( TextUtils.equals(editText.getText(),editTextAway.getText())){
                    Toast.makeText(new_game.this, "Team names cannot be the same.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent myIntent = new Intent(view.getContext(), StatsActivity.class);
                    //posiljanje imena ekip
                    String getHome = editText.getText().toString();
                    String getAway = editTextAway.getText().toString();
                    String getDatum = dateTimeDisplay.getText().toString();
                    Bundle bundleDatum = new Bundle();
                    Bundle bundle = new Bundle();
                    Bundle bundle1 = new Bundle();
                    bundle.putString("Home", getHome);
                    bundle1.putString("Away", getAway);
                    bundleDatum.putString("Datum", getDatum);
                    myIntent.putExtras(bundleDatum);
                    myIntent.putExtras(bundle);
                    myIntent.putExtras(bundle1);

                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}