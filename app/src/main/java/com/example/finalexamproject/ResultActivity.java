package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent it = getIntent();


        String str_name = it.getStringExtra("it_name");
        String sum = it.getStringExtra("it_sum");

        TextView tv_name = (TextView) findViewById(R.id.name);
        tv_name.setText(str_name);

        TextView tv_sum = (TextView) findViewById(R.id.sum);
        tv_sum.setText(sum);

        TextView tv_explain_title = (TextView) findViewById(R.id.explain_title);
        TextView tv_explain = (TextView) findViewById(R.id.explain);
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
            tv_explain_title.setText("매우 낮은 스트레스");
            tv_explain.setText("스트레스가 거의 없음\n 평온하고 안락한 상태\n " +
                    "심리적, 생리적 지표(예 : 심박수, 혈압) 정상 범위\n 일상 생활에 전혀 지장 없음");
        }



    }
}
