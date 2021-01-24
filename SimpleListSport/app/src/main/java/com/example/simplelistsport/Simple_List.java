package com.example.simplelistsport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Simple_List extends AppCompatActivity {

    private ListView MaListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple__list);

        //Associer votre viewavec son instance
        MaListe = (ListView) findViewById(R.id.pref);

        //Travailler avec les ressources du projet
        // Votre objet ressources
        Resources res = getResources();
        //Tableau des chaînes de caractères provenant du tableau défini dans strings.xml
        String[] MesValeurs = res.getStringArray(R.array.sportStrArray);

        //Remplir l’adaptateurArray
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MesValeurs);
        //Lier données à la liste
        MaListe.setAdapter(adapter);

        MaListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent goToForm = new Intent(Simple_List.this, detail_football.class);
                    startActivity(goToForm);
                    finish();
                }
                if (position == 1) {
                    Intent goToForm = new Intent(Simple_List.this, basket.class);
                    startActivity(goToForm);
                    finish();
                }
                if (position == 2) {
                    Intent goToForm = new Intent(Simple_List.this, rugby_details.class);
                    startActivity(goToForm);
                    finish();
                }
                if (position == 3) {
                    Intent goToForm = new Intent(Simple_List.this, bicycle_details.class);
                    startActivity(goToForm);
                    finish();
                }
                if (position == 4) {
                    Intent goToForm = new Intent(Simple_List.this, tennis_details.class);
                    startActivity(goToForm);
                    finish();
                }
            }
        });
    }
}
