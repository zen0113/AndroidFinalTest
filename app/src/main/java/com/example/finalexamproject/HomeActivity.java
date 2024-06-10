package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        try{
            DBManager dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            Cursor cursor = sdb.rawQuery("select name, birth, gender, stress from members", null);

            while(cursor.moveToNext())
            {
                String str_name = cursor.getString(0);

                TextView tv_name = (TextView) findViewById(R.id.name);
                tv_name.setText(str_name);
            }
            cursor.close();
            dbmgr.close();

        }catch (SQLiteException e)
        {
            TextView tv_list = new TextView(this);
            tv_list.append("DB Error!!");
        }

        Button btn_menu_write =(Button) findViewById(R.id.menu_write);
        btn_menu_write.setOnClickListener(this);

        Button btn_menu_home =(Button) findViewById(R.id.menu_profile);
        btn_menu_home.setOnClickListener(this);
    }

    public void onClick(View v)
    {

        if(v.getId() == R.id.menu_profile)
        {
            Intent it = new Intent(this, ProfileActivity.class);
            startActivity(it);
            finish();
        }
        if(v.getId() == R.id.menu_write)
        {
            Intent it = new Intent(this, DirayActivity.class);
            startActivity(it);
            finish();
        }
    }
}
