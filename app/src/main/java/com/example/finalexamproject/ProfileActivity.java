package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button btn_edit = (Button) findViewById(R.id.edit);
        btn_edit.setOnClickListener(this);

        Button btn_clear =(Button) findViewById(R.id.clear);
        btn_clear.setOnClickListener(this);

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
