package com.example.simplelistsport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bicycle_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_details);
    }

    public void mainClick(View view) {
        Intent SwitchToMainActivity = new Intent(bicycle_details.this, Simple_List.class);
        startActivity(SwitchToMainActivity);
        finish();
    }
}