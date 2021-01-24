package com.example.simplelistsport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detail_football extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footballdetails);
    }

    public void mainClick(View view) {
        Intent SwitchToMainActivity = new Intent(detail_football.this, Simple_List.class);
        startActivity(SwitchToMainActivity);
        finish();
    }
}