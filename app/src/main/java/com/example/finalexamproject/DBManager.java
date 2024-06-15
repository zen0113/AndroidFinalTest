package com.example.finalexamproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    public DBManager (Context context)
    {
        super(context, "myDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table members(name text, birth text, gender text, stress text);");
        db.execSQL("create table diray(title text, date text, stress int, memo text)");
        db.execSQL("create table stress(stress_1 int, stress_2 int, stress_3 int, stress_4 int, stress_5 int)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
