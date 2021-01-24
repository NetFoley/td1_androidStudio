package com.example.simplelistsport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class basket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
    }

    public void mainClick(View view) {
        Intent SwitchToMainActivity = new Intent(basket.this, Simple_List.class);
        startActivity(SwitchToMainActivity);
        finish();
    }
}