package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        String sum = "";
        DBManager dbmgr = new DBManager(this);

        try{

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            Cursor cursor = sdb.rawQuery("select name, birth, gender, stress from members", null);

            while(cursor.moveToNext())
            {
                String str_name = cursor.getString(0);
                String str_birth = cursor.getString(1);
                String str_gender = cursor.getString(2);
                sum = cursor.getString(3);

                TextView tv_name = (TextView) findViewById(R.id.name);
                tv_name.setText(str_name);

                TextView tv_birth = (TextView) findViewById(R.id.birth);
                tv_birth.setText(str_birth);

                TextView tv_gender = (TextView) findViewById(R.id.gender);
                tv_gender.setText(str_gender);

            }
            cursor.close();
            dbmgr.close();

        }catch (SQLiteException e)
        {
            TextView tv_list = new TextView(this);
            tv_list.append("DB Error!!");
        }

        ImageView img_stress1 = (ImageView) findViewById(R.id.image_1);
        ImageView img_stress2 = (ImageView) findViewById(R.id.image_2);
        ImageView img_stress3 = (ImageView) findViewById(R.id.image_3);
        ImageView img_stress4 = (ImageView) findViewById(R.id.image_4);
        ImageView img_stress5 = (ImageView) findViewById(R.id.image_5);

        if(sum.equals("100") || sum.equals("90"))
        {
            img_stress1.setVisibility(View.VISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
        }
        if(sum.equals("80") || sum.equals("70"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.VISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
        }
        if(sum.equals("60") || sum.equals("50"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.VISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
        }
        if(sum.equals("40") || sum.equals("30"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.VISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
        }
        if(sum.equals("20") || sum.equals("10") || sum.equals("0"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.VISIBLE);
        }

        try{
            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            Cursor cursor = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);

            while(cursor.moveToNext())
            {
                int int_stress_1 = cursor.getInt(0);
                int int_stress_2 = cursor.getInt(1);
                int int_stress_3 = cursor.getInt(2);
                int int_stress_4 = cursor.getInt(3);
                int int_stress_5 = cursor.getInt(4);

                TextView tv_stress_1 = (TextView) findViewById(R.id.cnt_1);
                tv_stress_1.setText(int_stress_1+"개");

                TextView tv_stress_2 = (TextView) findViewById(R.id.cnt_2);
                tv_stress_2.setText(int_stress_2+"개");

                TextView tv_stress_3 = (TextView) findViewById(R.id.cnt_3);
                tv_stress_3.setText(int_stress_3+"개");

                TextView tv_stress_4 = (TextView) findViewById(R.id.cnt_4);
                tv_stress_4.setText(int_stress_4+"개");

                TextView tv_stress_5 = (TextView) findViewById(R.id.cnt_5);
                tv_stress_5.setText(int_stress_5+"개");

            }
            cursor.close();
            dbmgr.close();

        }catch (SQLiteException e)
        {
            TextView tv_list = new TextView(this);
            tv_list.append("DB Error!!");
        }

        Button btn_edit = (Button) findViewById(R.id.edit);
        btn_edit.setOnClickListener(this);


        Button btn_menu_write =(Button) findViewById(R.id.menu_write);
        btn_menu_write.setOnClickListener(this);

        Button btn_menu_home =(Button) findViewById(R.id.menu_home);
        btn_menu_home.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        if(v.getId() == R.id.edit)
        {
            Intent it = new Intent(this, EditActivity.class);
            startActivity(it);
            finish();
        }
        if(v.getId() == R.id.menu_home)
        {
            Intent it = new Intent(this, HomeActivity.class);
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
