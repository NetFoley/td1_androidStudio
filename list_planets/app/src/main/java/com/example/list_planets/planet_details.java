package com.example.list_planets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class planet_details extends AppCompatActivity {

    private final String EXTRA_NAME = "name";
    private final String EXTRA_WEIGHT = "weight";
    private final String EXTRA_DESC = "desc";
    private final String EXTRA_RADIUS = "radius";
    private final String EXTRA_AGE = "age";
    private final String EXTRA_SPEED = "speed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);

        Intent monIntent= getIntent();
        String strName = monIntent.getStringExtra(EXTRA_NAME);
        String strDesc = monIntent.getStringExtra(EXTRA_DESC);
        String strRadius = monIntent.getStringExtra(EXTRA_RADIUS);
        String strWeight = monIntent.getStringExtra(EXTRA_WEIGHT);
        String strSpeed = monIntent.getStringExtra(EXTRA_SPEED);
        String strAge = monIntent.getStringExtra(EXTRA_AGE);

        int icon = monIntent.getIntExtra("EXTRA_ICON", R.drawable.planet);
        Log.i("msg", "Choice : '" + strName + "'");

        TextView twName = findViewById(R.id.twName);
        twName.setText(strName);
        TextView twDesc = findViewById(R.id.twDesc);
        twDesc.setText(strDesc);
        TextView twRadius = findViewById(R.id.twRadius );
        twRadius.setText(strRadius+ " km");
        TextView twSpeed = findViewById(R.id.twSpeed );
        twSpeed.setText(strSpeed+ " k/h");
        TextView twWeight = findViewById(R.id.twWeight);
        twWeight.setText(strWeight + " kg");
        TextView twAge = findViewById(R.id.twAge);
        twAge.setText(strAge + " billion years old");
        ImageView imageView = findViewById(R.id.planetIcon);
        imageView.setImageResource(icon);
    }

    public void mainClick(View view) {
        Intent SwitchToMainActivity = new Intent(planet_details.this, MainActivity.class);
        startActivity(SwitchToMainActivity);
        finish();
    }
}