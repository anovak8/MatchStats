package com.example.newstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add;
    DBHelperFinal DB;
    ArrayList<String> match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni, domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p;
    CustomAdapter customAdapter;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        DB = new DBHelperFinal(this);
        match_id = new ArrayList<>();
        domaci = new ArrayList<>();
        gosti = new ArrayList<>();
        domaci_goli = new ArrayList<>();
        gosti_goli = new ArrayList<>();
        domaci_rumeni = new ArrayList<>();
        gosti_rumeni = new ArrayList<>();
        domaci_rdeci = new ArrayList<>();
        gosti_rdeci = new ArrayList<>();
        domaci_streli = new ArrayList<>();
        gosti_streli = new ArrayList<>();
        domaci_p = new ArrayList<>();
        gosti_p = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni, domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
        private void displaydata() {
            Cursor cursor = DB.getData();
            if(cursor.getCount()==0){
                Toast.makeText(History.this, "No data.", Toast.LENGTH_SHORT).show();
                return;
            }else{
                while (cursor.moveToNext()){
                    match_id.add(cursor.getString(0));
                    domaci.add(cursor.getString(1));
                    gosti.add(cursor.getString(2));
                    domaci_goli.add(cursor.getString(3));
                    gosti_goli.add(cursor.getString(4));
                    domaci_rumeni.add(cursor.getString(5));
                    gosti_rumeni.add(cursor.getString(6));
                    domaci_rdeci.add(cursor.getString(7));
                    gosti_rdeci.add(cursor.getString(8));
                    domaci_streli.add(cursor.getString(9));
                    gosti_streli.add(cursor.getString(10));
                    domaci_p.add(cursor.getString(11));
                    gosti_p.add(cursor.getString(12));
                }
            }
        }


/*
        //recyclerView = findViewById(R.id.recyclerView);
        add = findViewById(R.id.stats);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), new_game.class);
                startActivityForResult(myIntent, 0);
            }

        });

 */
/*
        myDB =new MyDatabaseHelper(History.this);
        match_id = new ArrayList<>();
        domaci = new ArrayList<>();
        gosti = new ArrayList<>();
        domaci_goli = new ArrayList<>();
        gosti_goli = new ArrayList<>();
        domaci_rumeni = new ArrayList<>();
        gosti_rumeni = new ArrayList<>();
        domaci_rdeci = new ArrayList<>();
        gosti_rdeci = new ArrayList<>();
        domaci_streli = new ArrayList<>();
        gosti_streli = new ArrayList<>();
        domaci_p = new ArrayList<>();
        gosti_p = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(History.this, match_id, domaci, gosti, domaci_goli, gosti_goli, domaci_rumeni, gosti_rumeni, domaci_rdeci, gosti_rdeci, domaci_streli, gosti_streli, domaci_p, gosti_p);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(History.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();

        if ( cursor.getCount() == 0 ){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                domaci.add(cursor.getString(0));
                gosti.add(cursor.getString(1));
                domaci_goli.add(cursor.getString(2));
                gosti_goli.add(cursor.getString(3));
                domaci_rumeni.add(cursor.getString(4));
                gosti_rumeni.add(cursor.getString(5));
                domaci_rdeci.add(cursor.getString(6));
                gosti_rdeci.add(cursor.getString(7));
                domaci_streli.add(cursor.getString(8));
                gosti_streli.add(cursor.getString(9));
                domaci_p.add(cursor.getString(10));
                gosti_p.add(cursor.getString(11))   ;
            }
        }

*/
    }



