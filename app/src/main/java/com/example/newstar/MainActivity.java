package com.example.newstar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.startFootball);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), new_game.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button history = (Button) findViewById(R.id.History);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), History.class);
                startActivityForResult(myIntent, 0);
            }
        });

        //test
/*
        GridLayout grid = findViewById(R.id.grid);
        Button test = findViewById(R.id.test);

        Button button = new Button(this);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while (i != 0){
                    button(R.id.button[i]).setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    button.setText("Button");
                    i = i - 1;
                }


                grid.addView(button);
            }
        });
    */



    }
}