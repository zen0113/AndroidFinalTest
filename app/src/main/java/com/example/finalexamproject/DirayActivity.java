package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DirayActivity extends Activity implements View.OnClickListener {
    private DBManager dbmgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diray);

        Button btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        EditText et_title = (EditText) findViewById(R.id.edit_title);
        String str_title = et_title.getText().toString();

        EditText et_date = (EditText) findViewById(R.id.edit_date);
        String str_date = et_date.getText().toString();

        EditText et_memo = (EditText) findViewById(R.id.edit_memo);
        String str_memo = et_memo.getText().toString();

        RadioGroup rg_stress= (RadioGroup) findViewById(R.id.radiogroup_stress);
        int int_stress = 0;
        if(rg_stress.getCheckedRadioButtonId() == R.id.radio_stress1)
            int_stress = 1;
        if(rg_stress.getCheckedRadioButtonId() == R.id.radio_stress2)
            int_stress = 2;
        if(rg_stress.getCheckedRadioButtonId() == R.id.radio_stress3)
            int_stress = 3;
        if(rg_stress.getCheckedRadioButtonId() == R.id.radio_stress4)
            int_stress = 4;
        if(rg_stress.getCheckedRadioButtonId() == R.id.radio_stress5)
            int_stress = 5;

        try
        {
            dbmgr = new DBManager(this);
            SQLiteDatabase sdb;
            sdb = dbmgr.getWritableDatabase();

            sdb.execSQL("insert into diray values('"+str_title+"','"+str_date+"','"+int_stress+"', '"+str_memo+"');");
        }catch (SQLiteException e) {}

        Intent it = new Intent(this, HomeActivity.class);
        startActivity(it);
        finish();
    }
}
