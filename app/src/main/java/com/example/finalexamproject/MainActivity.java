package com.example.finalexamproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnStart = (Button) findViewById(R.id.start);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, SurveyActivity.class);
        startActivity(it);
        finish();
    }
}