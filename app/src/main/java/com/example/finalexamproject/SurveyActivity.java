package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SurveyActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);

        Button btn = (Button) findViewById(R.id.send);
        btn.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        EditText et_name = (EditText) findViewById(R.id.edit_name);
        String str_name = et_name.getText().toString();

        EditText et_birth = (EditText) findViewById(R.id.edit_birth);
        String str_birth = et_birth.getText().toString();

        int sum = 0;
        RadioGroup rg_question1 = (RadioGroup) findViewById(R.id.radiogroup_question1);
        if(rg_question1.getCheckedRadioButtonId() == R.id.radio_yes1)
            sum += 1;
        RadioGroup rg_question2 = (RadioGroup) findViewById(R.id.radiogroup_question2);
        if(rg_question2.getCheckedRadioButtonId() == R.id.radio_yes2)
            sum += 1;
        RadioGroup rg_question3 = (RadioGroup) findViewById(R.id.radiogroup_question3);
        if(rg_question3.getCheckedRadioButtonId() == R.id.radio_yes3)
            sum += 1;
        RadioGroup rg_question4 = (RadioGroup) findViewById(R.id.radiogroup_question4);
        if(rg_question4.getCheckedRadioButtonId() == R.id.radio_yes4)
            sum += 1;
        RadioGroup rg_question5 = (RadioGroup) findViewById(R.id.radiogroup_question5);
        if(rg_question5.getCheckedRadioButtonId() == R.id.radio_yes5)
            sum += 1;
        RadioGroup rg_question6 = (RadioGroup) findViewById(R.id.radiogroup_question6);
        if(rg_question6.getCheckedRadioButtonId() == R.id.radio_yes6)
            sum += 1;
        RadioGroup rg_question7 = (RadioGroup) findViewById(R.id.radiogroup_question7);
        if(rg_question7.getCheckedRadioButtonId() == R.id.radio_yes7)
            sum += 1;
        RadioGroup rg_question8 = (RadioGroup) findViewById(R.id.radiogroup_question8);
        if(rg_question8.getCheckedRadioButtonId() == R.id.radio_yes8)
            sum += 1;
        RadioGroup rg_question9 = (RadioGroup) findViewById(R.id.radiogroup_question9);
        if(rg_question9.getCheckedRadioButtonId() == R.id.radio_yes9)
            sum += 1;
        RadioGroup rg_question10 = (RadioGroup) findViewById(R.id.radiogroup_question10);
        if(rg_question10.getCheckedRadioButtonId() == R.id.radio_yes10)
            sum += 1;

        Intent it = new Intent(this, ResultActivity.class);

        it.putExtra("it_name", str_name);
        it.putExtra("it_sum", Integer.toString(100 - sum * 10));

        startActivity(it);
        finish();
    }
}
