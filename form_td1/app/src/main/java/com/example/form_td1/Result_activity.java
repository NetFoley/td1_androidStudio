package com.example.form_td1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {

    String EXTRA_NOM = "nom";
    String EXTRA_PRENOM = "prenom";
    String EXTRA_EMAIL = "email";
    String EXTRA_GENDER = "gender";
    String EXTRA_LANGUAGES = "languages";
    String EXTRA_PLAYTIME = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        Intent monIntent= getIntent();
        String strName = monIntent.getStringExtra(EXTRA_NOM);
        String strFirstName = monIntent.getStringExtra(EXTRA_PRENOM);
        String strMail = monIntent.getStringExtra(EXTRA_EMAIL);
        String strGender = monIntent.getStringExtra(EXTRA_GENDER);
        String strLanguages = monIntent.getStringExtra(EXTRA_LANGUAGES); //strLanguages.split(" ", 4);...
        String strPlaytime = monIntent.getStringExtra(EXTRA_PLAYTIME);

        TextView twName = findViewById(R.id.name);
        TextView twFName = findViewById(R.id.firstName);
        TextView twMail = findViewById(R.id.mail);
        TextView twGender = findViewById(R.id.gender);
        TextView twLang = findViewById(R.id.lang);
        TextView twPlayT = findViewById(R.id.playtime);

        twName.setText(strName);
        twFName.setText(strFirstName);
        twMail.setText(strMail);
        twGender.setText(strGender);
        twLang.setText(strLanguages);
        twPlayT.setText(strPlaytime);

        Log.i("msg", strName);
        Log.i("msg", strFirstName);
        Log.i("msg", strMail);
        Log.i("msg", strGender);
        Log.i("msg", strLanguages);
        Log.i("msg", strPlaytime);
    }
}