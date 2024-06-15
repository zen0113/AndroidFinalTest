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

import androidx.core.content.ContextCompat;

public class DirayActivity extends Activity implements View.OnClickListener {
    private DBManager dbmgr;
    private String[] wordsArray_1 = {"기쁨", "행복", "설렘", "환희", "만족", "뿌듯", "기대", "감사", "사랑", "열정", "희망"};
    private String[] wordsArray_2 = {"짜증", "피로", "걱정", "답답", "초조", "좌절", "실망", "당황", "허탈", "혼란", "분노"};
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


        int int_stress = countWordsInText(str_memo, wordsArray_1) - countWordsInText(str_memo, wordsArray_2);


        try
        {
            dbmgr = new DBManager(this);
            SQLiteDatabase sdb;
            sdb = dbmgr.getWritableDatabase();

            sdb.execSQL("insert into diray values('"+str_title+"','"+str_date+"','"+int_stress+"', '"+str_memo+"');");

            if(int_stress >= 5)
                sdb.execSQL("update stress set stress_1 = stress_1 + 1;");
            else if(int_stress < 5 && int_stress >= 3)
                sdb.execSQL("update stress set stress_2 = stress_2 + 1;");
            else if(int_stress < 3 && int_stress >= 0)
                sdb.execSQL("update stress set stress_3 = stress_3 + 1;");
            else if(int_stress < 0 && int_stress >= -3)
                sdb.execSQL("update stress set stress_4 = stress_4 + 1;");
            else
                sdb.execSQL("update stress set stress_5 = stress_5 + 1;");

        }catch (SQLiteException e) {}



        Intent it = new Intent(this, HomeActivity.class);
        startActivity(it);
        finish();
    }
    private int countWordsInText(String text, String[] wordsArray) {
        int count = 0;
        for (String word : wordsArray) {
            count += countOccurrences(text, word);
        }
        return count;
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
