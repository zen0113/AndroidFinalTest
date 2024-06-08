package com.example.finalexamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent it = new Intent(this, ProfileActivity.class);
        startActivity(it);
        finish();
    }
}
