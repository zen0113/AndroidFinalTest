package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DirayMainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diray_main);

        Intent it = getIntent();


        String str_name = it.getStringExtra("it_name");
        String sum = it.getStringExtra("it_sum");

        TextView tv_name = (TextView) findViewById(R.id.name);
        tv_name.setText(str_name);

        TextView tv_sum = (TextView) findViewById(R.id.sum);
        tv_sum.setText(sum);



    }
}
