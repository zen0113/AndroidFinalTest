package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        Button btn = (Button) findViewById(R.id.ok);
        btn.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        EditText et_name=(EditText) findViewById(R.id.edit_name);
        String str_name=et_name.getText().toString();

        EditText et_birth=(EditText) findViewById(R.id.edit_birth);
        String str_birth=et_birth.getText().toString();

        RadioGroup rg_gender = (RadioGroup) findViewById(R.id.radiogroup_gender);
        String str_gender = "";
        if(rg_gender.getCheckedRadioButtonId() == R.id.radio_male)
            str_gender = "남자";
        if(rg_gender.getCheckedRadioButtonId() == R.id.radio_female)
            str_gender = "여자";

        String str_name_bf = "";
        String str_birth_bf = "";
        String str_gender_bf = "";

        try {
            DBManager dbmgr = new DBManager(this);
            SQLiteDatabase sdb;
            sdb = dbmgr.getWritableDatabase();

            Cursor cursor = sdb.rawQuery("select name, birth, gender, stress from members", null);
            while(cursor.moveToNext()) {
                str_name_bf = cursor.getString(0);
                str_birth_bf = cursor.getString(1);
                str_gender_bf = cursor.getString(2);
            }

            if(str_name.length()!=0)
                sdb.execSQL("update members set name = '"+str_name+"' where name = '"+str_name_bf+"'");
            if(str_birth.length()!=0)
                sdb.execSQL("update members set birth = '"+str_birth+"' where birth = '"+str_birth_bf+"'");
            if(str_gender.length()!=0)
                sdb.execSQL("update members set gender = '"+str_gender+"' where gender = '"+str_gender_bf+"'");

            cursor.close();
            dbmgr.close();
        }catch (SQLiteException e) {}

        Intent it = new Intent(this, ProfileActivity.class);
        startActivity(it);
        finish();
    }
}
