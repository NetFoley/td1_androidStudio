package com.example.list_planets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String EXTRA_NAME = "name";
    private final String EXTRA_WEIGHT = "weight";
    private final String EXTRA_DESC = "desc";
    private final String EXTRA_RADIUS = "radius";
    private final String EXTRA_AGE = "age";
    private final String EXTRA_SPEED = "speed";
    private final int EXTRA_ICON = R.drawable.planet;

    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;
    private ArrayList<planet> monDataset = new ArrayList<planet>();
    private ArrayList<planet> planetList = new ArrayList<planet>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planet earth = new planet();
        earth.setIcon(R.drawable.earth);
        earth.setName("Earth");
        earth.setWeight("5,9736*10^24");
        earth.setDesc("Earth is the third plane.");
        earth.setAge("7,641");
        earth.setSpeed("164");
        earth.setRadius("91540");
        planetList.add(earth);
        monDataset.add(earth);

        planet jupiter = new planet();
        jupiter.setIcon(R.drawable.jupiter);
        jupiter.setName("Jupiter");
        jupiter.setWeight("267,46*10^22");;
        jupiter.setIcon(R.drawable.jupiter);;
        earth.setDesc("Earth is the third plane.");
        earth.setAge("7,641");
        earth.setSpeed("164");
        earth.setRadius("91540");
        planetList.add(jupiter);
        monDataset.add(jupiter);

        planet saturn = new planet();
        saturn.setIcon(R.drawable.saturn);
        saturn.setName("Saturn");
        saturn.setWeight("568,46*10^24");;
        earth.setDesc("Earth is the third planet f.");
        earth.setAge("7,641");
        earth.setSpeed("164");
        earth.setRadius("91540");
        planetList.add(saturn);
        monDataset.add(saturn);

        planet mars = new planet();
        mars.setIcon(R.drawable.mars);
        mars.setName("Mars");
        mars.setWeight("9,7562*10^17");;
        earth.setDesc("Earth is the third planet.");
        earth.setAge("7,641");
        earth.setSpeed("164");
        earth.setRadius("91540");
        planetList.add(mars);
        monDataset.add(mars);

        monRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        monRecyclerView.setHasFixedSize(true); //Taille fixe des éléments de la liste = optimisation du recyclerView
        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);
        monAdapter = new PlanetAdapter(monDataset);
        //cf. rec_adapter.java, classe de l’adaptateur
        monRecyclerView.setAdapter(monAdapter);
        monRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.i("msg", "ouvrir details " + monDataset.get(position).getName());

                Intent goToDetails = new Intent(MainActivity.this, planet_details.class);
                goToDetails.putExtra(EXTRA_NAME, monDataset.get(position).getName());
                goToDetails.putExtra(EXTRA_WEIGHT, monDataset.get(position).getWeight());
                goToDetails.putExtra(EXTRA_DESC, monDataset.get(position).getDesc());
                goToDetails.putExtra(EXTRA_RADIUS, monDataset.get(position).getRadius());
                goToDetails.putExtra(EXTRA_AGE, monDataset.get(position).getAge());
                goToDetails.putExtra(EXTRA_SPEED, monDataset.get(position).getSpeed());
                goToDetails.putExtra("EXTRA_ICON", monDataset.get(position).getIcon());
                startActivity(goToDetails);
                finish();
            }
        }));

        EditText editSearch = findViewById(R.id.inputSearch);
        editSearch.addTextChangedListener(new TextWatcher() {

            @SuppressLint("ResourceAsColor")
            public void afterTextChanged(Editable s) {
                filtrer();
            }
            public void filtrer(){
                // récupérer la chaine saisie par l'utilisateur
                String str = editSearch.getText().toString();
                // créer une nouvelle liste qui va contenir la résultat à afficher

                //Bouclersurlalistedesnoms,avec une iteration  (
                monDataset.clear();
                for (planet planeti: planetList) {
                    if(planeti.getName().startsWith(str))
                        monDataset.add(planeti);
                    // si le nom du foodcommence par la chaine saisie , l’ajouter à la nouvelle liste (newList.add(food))
                    // Se servir de la méthode   startsWith(name) pour chercher la sous-chaîne.
                    // Il faut aussi vider la liste : MonListView.setAdapter(null);
                    monAdapter = new PlanetAdapter(monDataset);
                    //cf. rec_adapter.java, classe de l’adaptateur
                    monRecyclerView.setAdapter(monAdapter);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

}
