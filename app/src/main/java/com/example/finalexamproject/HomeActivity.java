package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class HomeActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        DBManager dbmgr = new DBManager(this);
        try{

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

        ListView listView;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        int i = 0;
        try{

            SQLiteDatabase sdb = dbmgr.getReadableDatabase();

            Cursor cursor = sdb.rawQuery("select title, date, stress, memo from diray", null);


            while(cursor.moveToNext())
            {
                String str_title = cursor.getString(0);
                String str_date = cursor.getString(1);
                int int_stress = cursor.getInt(2);
                String str_memo = cursor.getString(3);


                if(int_stress >= 5)
                {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_stress_1), str_title, str_date, str_memo);
                    Cursor cursor2 = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);
                    while(cursor2.moveToNext())
                    {
                        int int_stress_1 = cursor2.getInt(0);

                        if(int_stress_1 == 5)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price), "당신은 강합니다", " ", "지금까지 해온 것처럼 계속 힘내세요. 당신은 충분히 강하고, " +
                                    "모든 어려움을 이겨낼 수 있어요. 연구에 따르면, 자기 효능감이 높을수록 스트레스 상황을 더 잘 극복할 수 있습니다.");
                        if(int_stress_1 == 10)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price), "스스로에게 박수를!", " ", "오늘의 노력에 대해 스스로에게 박수를 보내세요. " +
                                    "당신은 더 나은 내일을 위해 최선을 다하고 있어요. 자기 격려는 긍정적인 자기 인식을 높이는 데 중요한 역할을 합니다.");
                    }
                    cursor2.close();
                }

                else if(int_stress < 5 && int_stress >= 3) {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_stress_2), str_title, str_date, str_memo);
                    Cursor cursor2 = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);
                    while (cursor2.moveToNext()) {
                        int int_stress_2 = cursor2.getInt(1);

                        if (int_stress_2 == 5)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price_3), "한 걸음 한 걸음", " ", "스트레스를 하나씩 줄여가는 모습이 너무 멋져요. 한 걸음 한 걸음, 당신의 목표에 가까워지고 있습니다. " +
                                    "단계별 접근이 스트레스 관리에 효과적이라고 해요.");
                        if (int_stress_2 == 10)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price_3), "오늘도 수고했어요", " ", "오늘도 스트레스를 줄이기 위해 수고했어요. " +
                                    "당신의 노력이 언젠가는 큰 결실을 맺을 거예요. 일상적인 노력과 성과 인식이 스트레스 관리에 큰 도움이 된다고 해요.");
                    }
                    cursor2.close();
                }
                else if(int_stress < 3 && int_stress >= 0)
                {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_stress_3), str_title, str_date, str_memo);
                    Cursor cursor2 = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);
                    while (cursor2.moveToNext()) {
                        int int_stress_3 = cursor2.getInt(2);

                        if (int_stress_3 == 5)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price_2), "새로운 시작", " ", "스트레스를 줄이면서 새로운 시작을 맞이하고 있어요. " +
                                    "당신의 새로운 도전은 언제나 응원받을 가치가 있습니다. 새로운 시작과 변화는 긍정적인 에너지를 가져다준다고 해요.");
                        if (int_stress_3 == 10)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.price_2), "당신은 소중해요", " ", "당신은 정말 소중한 사람입니다. 스트레스를 줄이는 " +
                                    "과정에서도 자신을 사랑하고 아껴주세요. 당신은 충분히 가치 있는 존재입니다. 자기 존중감과 자기애가 스트레스 관리와 정신 건강에 긍정적인 영향을 미친다고 해요.");
                    }
                    cursor2.close();
                }

                else if(int_stress < 0 && int_stress >= -3)
                {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_stress_4), str_title, str_date, str_memo);
                    Cursor cursor2 = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);
                    while (cursor2.moveToNext()) {
                        int int_stress_4 = cursor2.getInt(3);

                        if (int_stress_4 == 5)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.warn_2), "당신은 혼자가 아닙니다", " ", "당신이 혼자가 아님을 기억하세요. 주변에 도움을 청하고, " +
                                    "당신을 응원하는 사람들이 있다는 것을 잊지 마세요. 연구에 따르면, 사회적 지지는 스트레스 수준을 낮추는 데 중요한 역할을 합니다.");
                        if (int_stress_4 == 10)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.warn_2), "오늘도 수고했어요", " ", "오늘도 힘든 하루를 잘 견뎌냈어요. " +
                                    "당신의 노력은 결코 헛되지 않을 거예요. 전문가들은 하루를 잘 마무리하는 것도 스트레스 관리에 도움이 된다고 말합니다. 조금 더 힘내봐요.");
                    }
                    cursor2.close();
                }

                else
                {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile_stress_5), str_title, str_date, str_memo);
                    Cursor cursor2 = sdb.rawQuery("select stress_1, stress_2, stress_3, stress_4, stress_5 from stress", null);
                    while (cursor2.moveToNext()) {
                        int int_stress_5 = cursor2.getInt(4);

                        if (int_stress_5 == 5)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.warn), "잠시 쉬어가세요", " ", "지금 많이 힘들죠? 잠시 쉬어가는 것도 괜찮아요. 숨을 깊게 쉬고, " +
                                    "마음을 차분하게 다스려보세요. 전문가들은 짧은 휴식이 스트레스를 줄이는 데 도움이 된다고 말합니다. 당신은 이겨낼 수 있어요.");
                        if (int_stress_5 == 10)
                            adapter.addItem(ContextCompat.getDrawable(this, R.drawable.warn), "힘들 땐 휴식이 필요해요", " ", "힘들 때는 잠시 휴식을 취하는 것이 중요합니다. " +
                                    "잠깐이라도 편히 쉴 수 있는 시간을 가져보세요. 전문가들은 충분한 휴식이 스트레스를 줄이는 데 필수적이라고 조언합니다. 당신의 마음이 조금 더 가벼워질 거예요.");

                    }
                    cursor2.close();
                }




                i++;
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
