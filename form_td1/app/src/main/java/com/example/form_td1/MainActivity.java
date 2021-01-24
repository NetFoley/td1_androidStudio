package com.example.form_td1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.*;

import java.util.Date;
import java.time.LocalDate;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    String EXTRA_NOM = "nom";
    String EXTRA_PRENOM = "prenom";
    String EXTRA_EMAIL = "email";
    String EXTRA_GENDER = "gender";
    String EXTRA_LANGUAGES = "languages";
    String EXTRA_PLAYTIME = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("msg", "Launching App form_td1");

        setContentView(R.layout.activity_form);
        TextView dateTW = findViewById(R.id.date);
        Date currentDate = new Date();
        dateTW.setText(currentDate.toString());

        EditText editName = findViewById(R.id.editTextTextPersonName);
        editName.addTextChangedListener(this);
        EditText editFirstName = findViewById(R.id.editTextTextPersonFirstName);
        editFirstName.addTextChangedListener(this);

        EditText editPlayTime = findViewById(R.id.editTextPlayTime);
        editPlayTime.addTextChangedListener(new TextWatcher() {

            @SuppressLint("ResourceAsColor")
            public void afterTextChanged(Editable s) {
                Log.i("msg", "Input : '" + editPlayTime.getText().toString() + "'");
                if(!(editPlayTime.getText().toString().equals("")))
                {
                    int time = Integer.parseInt(editPlayTime.getText().toString());
                    Log.i("msg", "Time played : " + time);
                    if(time > -1)
                    {
                        if(time > 40)
                        {
                            editPlayTime.setTextColor(getColor(R.color.red));
                            Snackbar snackbar_1 = Snackbar.make(findViewById(R.id.activity_form_layout), R.string.timeHigh, Snackbar.LENGTH_SHORT);
                            snackbar_1.show();
                        }
                        else if(time > 20)
                        {
                            editPlayTime.setTextColor(getColor(R.color.orange));
                            Snackbar snackbar_1 = Snackbar.make(findViewById(R.id.activity_form_layout), R.string.timeMedium, Snackbar.LENGTH_SHORT);
                            snackbar_1.show();
                        }
                        else
                        {
                            editPlayTime.setTextColor(getColor(R.color.green));
                            Snackbar snackbar_1 = Snackbar.make(findViewById(R.id.activity_form_layout), R.string.timeLow, Snackbar.LENGTH_SHORT);
                            snackbar_1.show();
                        }
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    public void sendClick(View view) {

        EditText editNom = findViewById(R.id.editTextTextPersonName);
        EditText editPrenom = findViewById(R.id.editTextTextPersonFirstName);
        EditText editMail = findViewById(R.id.editEmail);
        RadioButton radioGender = findViewById(R.id.radioMale);
        CheckBox checkBoxC = findViewById(R.id.checkBoxProgC);
        CheckBox checkBoxJava = findViewById(R.id.checkBoxProgJava);
        CheckBox checkBoxJS = findViewById(R.id.checkBoxProgJS);
        CheckBox checkBoxPhpSql = findViewById(R.id.checkBoxProgPhpSql);
        EditText editPlayTime = findViewById(R.id.editTextPlayTime);

        String gender = "Female";
        if(radioGender.isChecked()){gender = "Male";}

        String languages = "";
        if(checkBoxC.isChecked()) {languages += "C ";}
        if(checkBoxJava.isChecked()) {languages += "Java ";}
        if(checkBoxJS.isChecked()) {languages += "JS ";}
        if(checkBoxPhpSql.isChecked()) {languages += "PhpSql ";}

        Intent GotoResults = new Intent(MainActivity.this, Result_activity.class);
        Log.i("msg", "NOM VALUE : " + editNom.getText().toString());
        GotoResults.putExtra(EXTRA_NOM, editNom.getText().toString());
        GotoResults.putExtra(EXTRA_PRENOM, editPrenom.getText().toString());
        GotoResults.putExtra(EXTRA_EMAIL, editMail.getText().toString());
        GotoResults.putExtra(EXTRA_LANGUAGES, languages);
        GotoResults.putExtra(EXTRA_GENDER, gender);
        if(editPlayTime.getText().toString().equals("")){GotoResults.putExtra(EXTRA_PLAYTIME, "0");}else{GotoResults.putExtra(EXTRA_PLAYTIME, editPlayTime.getText().toString());}

        startActivity(GotoResults);
        finish();
    }


    public void welcomeGender(View view)
    {
        RadioButton radio = findViewById(R.id.radioMale);
        EditText editFirstName = findViewById(R.id.editTextTextPersonFirstName);
        Log.i("msg", "Radio gender clicked");
        if(radio.isChecked())
        {
            Snackbar snackbar_1 = Snackbar.make(findViewById(R.id.activity_form_layout), "Welcome mr " + editFirstName.getText().toString(), Snackbar.LENGTH_SHORT);
            snackbar_1.show();
        }
        else
        {
            Snackbar snackbar_1 = Snackbar.make(findViewById(R.id.activity_form_layout), "Welcome ms " + editFirstName.getText().toString(), Snackbar.LENGTH_SHORT);
            snackbar_1.show();
        }
    }

    public void resetClick(View view)
    {
        Log.i("msg","Resetting the form");
        EditText editNom = findViewById(R.id.editTextTextPersonName);
        EditText editPrenom = findViewById(R.id.editTextTextPersonFirstName);
        EditText editMail = findViewById(R.id.editEmail);
        RadioButton radioGenderMale = findViewById(R.id.radioMale);
        RadioButton radioGenderFemale = findViewById(R.id.radioFemale);
        CheckBox checkBoxC = findViewById(R.id.checkBoxProgC);
        CheckBox checkBoxJava = findViewById(R.id.checkBoxProgJava);
        CheckBox checkBoxJS = findViewById(R.id.checkBoxProgJS);
        CheckBox checkBoxPhpSql = findViewById(R.id.checkBoxProgPhpSql);
        EditText editPlayTime = findViewById(R.id.editTextPlayTime);

        editPrenom.setText("");
        editNom.setText("");
        editMail.setText("");
        editPlayTime.setText("");
        radioGenderMale.setChecked(false);
        radioGenderFemale.setChecked(true);
        checkBoxC.setChecked(false);
        checkBoxJava.setChecked(false);
        checkBoxJS.setChecked(false);
        checkBoxPhpSql.setChecked(false);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        EditText editName = findViewById(R.id.editTextTextPersonName);
        EditText editFirstName = findViewById(R.id.editTextTextPersonFirstName);
        EditText mail = findViewById(R.id.editEmail);
        mail.setText(editName.getText() + "." + editFirstName.getText() + "@ludus-academie.com");
    }

    public void swapAvatar(View view)
    {
        ImageView avatar = findViewById(R.id.avatarImg);
        // initiate a Switch
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);

        // check current state of a Switch (true or false).
        Boolean switchState = simpleSwitch.isChecked();
        if(!switchState)
        {
            avatar.setImageResource(R.drawable.bigdrake_small);
        }
        else
        {
            avatar.setImageResource(R.drawable.skeleton_small);
        }
    }
}