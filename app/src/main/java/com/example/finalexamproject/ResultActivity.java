package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //Intent it = getIntent();


        String str_name = "";
        String sum = "";

        //TextView tv_name = (TextView) findViewById(R.id.name);
        //tv_name.setText(str_name);

        //TextView tv_sum = (TextView) findViewById(R.id.sum);
        //tv_sum.setText(sum);

        try{
            DBManager dbmgr = new DBManager(this);

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            Cursor cursor = sdb.rawQuery("select name, birth, gender, stress from members", null);

            while(cursor.moveToNext())
            {
                str_name = cursor.getString(0);
                sum = cursor.getString(3);

                TextView tv_name = (TextView) findViewById(R.id.name);
                tv_name.setText(str_name);


                TextView tv_stress = (TextView) findViewById(R.id.sum);
                tv_stress.setText(sum);
            }
            cursor.close();
            dbmgr.close();

        }catch (SQLiteException e)
        {
            TextView tv_list = new TextView(this);
            tv_list.append("DB Error!!");
        }


        TextView tv_explain_title = (TextView) findViewById(R.id.explain_title);
        TextView tv_explain = (TextView) findViewById(R.id.explain);
        ImageView img_stress1 = (ImageView) findViewById(R.id.image_1);
        ImageView img_stress2 = (ImageView) findViewById(R.id.image_2);
        ImageView img_stress3 = (ImageView) findViewById(R.id.image_3);
        ImageView img_stress4 = (ImageView) findViewById(R.id.image_4);
        ImageView img_stress5 = (ImageView) findViewById(R.id.image_5);
        ImageView img_stress11 = (ImageView) findViewById(R.id.image_11);
        ImageView img_stress22 = (ImageView) findViewById(R.id.image_22);
        ImageView img_stress33 = (ImageView) findViewById(R.id.image_33);
        ImageView img_stress44 = (ImageView) findViewById(R.id.image_44);
        ImageView img_stress55 = (ImageView) findViewById(R.id.image_55);

        if(sum.equals("100") || sum.equals("90"))
        {
            img_stress1.setVisibility(View.VISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
            img_stress11.setVisibility(View.VISIBLE);
            img_stress22.setVisibility(View.INVISIBLE);
            img_stress33.setVisibility(View.INVISIBLE);
            img_stress44.setVisibility(View.INVISIBLE);
            img_stress55.setVisibility(View.INVISIBLE);
            tv_explain_title.setText("매우 낮은 스트레스");
            tv_explain.setText("스트레스가 거의 없고\n평온하고 안락한 상태이시군요.\n" +
                    "스트레가 일상 생활에 지장이 없을거라 판단됩니다!\n좋아요! 이대로 계속 유지해봅시다.");
        }
        if(sum.equals("80") || sum.equals("70"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.VISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
            img_stress11.setVisibility(View.INVISIBLE);
            img_stress22.setVisibility(View.VISIBLE);
            img_stress33.setVisibility(View.INVISIBLE);
            img_stress44.setVisibility(View.INVISIBLE);
            img_stress55.setVisibility(View.INVISIBLE);
            tv_explain_title.setText("낮은 스트레스");
            tv_explain.setText("가벼운 스트레스가 있고\n일상적인 상황에서 약간의 긴장감을 느끼시군요.\n" +
                    "하지만 대부분의 상황에서 스트레스 관리가\n가능하다고 판단됩니다!");
        }
        if(sum.equals("60") || sum.equals("50"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.VISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
            img_stress11.setVisibility(View.INVISIBLE);
            img_stress22.setVisibility(View.INVISIBLE);
            img_stress33.setVisibility(View.VISIBLE);
            img_stress44.setVisibility(View.INVISIBLE);
            img_stress55.setVisibility(View.INVISIBLE);
            tv_explain_title.setText("중간 스트레스");
            tv_explain.setText("스트레스가 생활에 어느 정도\n영향을 미칠 것이라고 판단됩니다!\n" +
                    "특정 상황에서는 스트레스 반응이 뚜렷할 수 있습니다\n마음 지도를 그려보 스트레스를 줄여봅시다!");
        }
        if(sum.equals("40") || sum.equals("30"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.VISIBLE);
            img_stress5.setVisibility(View.INVISIBLE);
            img_stress11.setVisibility(View.INVISIBLE);
            img_stress22.setVisibility(View.INVISIBLE);
            img_stress33.setVisibility(View.INVISIBLE);
            img_stress44.setVisibility(View.VISIBLE);
            img_stress55.setVisibility(View.INVISIBLE);
            tv_explain_title.setText("높은 스트레스");
            tv_explain.setText("스트레스 관리가 필요할 상태입니다!\n일상 생활에서 빈번하게 스트레스 반응이 일어나고\n" +
                    "심리적으로 불편함을 느낄 수 있다고 판단됩니다.\n마음 지도를 그려보며 스트레스를 줄여봅시다!");
        }
        if(sum.equals("20") || sum.equals("10") || sum.equals("0"))
        {
            img_stress1.setVisibility(View.INVISIBLE);
            img_stress2.setVisibility(View.INVISIBLE);
            img_stress3.setVisibility(View.INVISIBLE);
            img_stress4.setVisibility(View.INVISIBLE);
            img_stress5.setVisibility(View.VISIBLE);
            img_stress11.setVisibility(View.INVISIBLE);
            img_stress22.setVisibility(View.INVISIBLE);
            img_stress33.setVisibility(View.INVISIBLE);
            img_stress44.setVisibility(View.INVISIBLE);
            img_stress55.setVisibility(View.VISIBLE);
            tv_explain_title.setText("매우 높은 스트레스");
            tv_explain.setText("지속적이고 강한 스트레스를 받고 있습니다!\n일상 생활에서 심각한 영향을 미칠 수 있고\n" +
                    "심한 불안과 긴장감을 느낄 수 있다고 판단됩니다\n마음 지도를 그려보며 스트레스를 줄여봅시다!");
        }

        Button btn = (Button) findViewById(R.id.start);
        btn.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        Intent it = new Intent(this, HomeActivity.class);
        startActivity(it);
        finish();
    }
}
