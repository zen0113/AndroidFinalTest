package com.example.finalexamproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnStart = (Button) findViewById(R.id.start);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DBManager dbmgr = new DBManager(this);
        try{
            SQLiteDatabase sdb = dbmgr.getReadableDatabase();
            Cursor cursor = sdb.rawQuery("select name, birth, gender, stress from members", null);
            if (cursor.getCount() > 0)
            {
                Intent it = new Intent(this, HomeActivity.class);
                startActivity(it);
            }
            else
            {
                Intent it = new Intent(this, SurveyActivity.class);
                startActivity(it);
            }
            cursor.close();
            dbmgr.close();

        }catch (SQLiteException e)
        {
            TextView tv_list = new TextView(this);
            tv_list.append("DB Error!!");
        }

        finish();
    }
}