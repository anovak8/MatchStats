package com.example.newstar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Matches.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME="old_match";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_HOME_TEAM= "home_team";
    private static final String COLUMN_AWAY_TEAM= "away_team";
    private static final String COLUMN_HOME_GOALS = "home_goal";
    private static final String COLUMN_AWAY_GOALS = "away_goals";
    private static final String COLUMN_HOME_YC = "home_yc";
    private static final String COLUMN_AWAY_YC = "away_yc";
    private static final String COLUMN_HOME_RC = "home_rc";
    private static final String COLUMN_AWAY_RC = "away_rc";
    private static final String COLUMN_HOME_SHOTS = "home_shots";
    private static final String COLUMN_AWAY_SHOTS = "away_shots";
    private static final String COLUMN_HOME_POSESSION = "home_p";
    private static final String COLUMN_AWAY_POSESSION = "away_p";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_HOME_TEAM + " TEXT, " + COLUMN_AWAY_TEAM + " TEXT, " +
                        COLUMN_HOME_GOALS + " INTEGER, " + COLUMN_AWAY_GOALS + " INTEGER, " +
                        COLUMN_HOME_YC + " INTEGER, " + COLUMN_AWAY_YC + " INTEGER, " +
                        COLUMN_HOME_RC + " INTEGER, " + COLUMN_AWAY_RC + " INTEGER, " +
                        COLUMN_HOME_SHOTS + " INTEGER, " + COLUMN_AWAY_SHOTS + " INTEGER, " +
                        COLUMN_HOME_POSESSION + " INTEGER, " + COLUMN_AWAY_POSESSION + " INTEGER);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addMatch (String home_team, String away_team, int home_goals, int away_goals, int home_yc, int away_yc, int home_rc, int away_rc, int home_shots, int away_shots, int home_p, int away_p){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HOME_TEAM, home_team);
        cv.put(COLUMN_AWAY_TEAM, away_team);
        cv.put(COLUMN_HOME_GOALS, home_goals);
        cv.put(COLUMN_AWAY_GOALS, away_goals);
        cv.put(COLUMN_HOME_YC, home_yc);
        cv.put(COLUMN_AWAY_YC, away_yc);
        cv.put(COLUMN_HOME_RC, home_rc);
        cv.put(COLUMN_AWAY_RC, away_rc);
        cv.put(COLUMN_HOME_SHOTS, home_shots);
        cv.put(COLUMN_AWAY_SHOTS, away_shots);
        cv.put(COLUMN_HOME_POSESSION, home_p);
        cv.put(COLUMN_AWAY_POSESSION, away_p);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }

    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if( db != null ){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
