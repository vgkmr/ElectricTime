package com.example.vgk.electrictimefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText dist;
    EditText time;
    RadioButton walking;
    RadioButton boosted;
    RadioButton segway;
    RadioButton evolve;
    RadioButton hoverboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dist = (EditText)findViewById(R.id.ogTimeEditText);
        walking = (RadioButton)findViewById(R.id.walkingradioButton);
        boosted = (RadioButton)findViewById(R.id.boostedradioButton);
        segway = (RadioButton)findViewById(R.id.segwayradioButton);
        evolve = (RadioButton)findViewById(R.id.evolveradioButton);
        hoverboard = (RadioButton)findViewById(R.id.hoverboardradioButton);
        time = (EditText)findViewById(R.id.timeEditText);

        configureNextButton();

    }

    private void configureNextButton() {
        Button nextButton = findViewById(R.id.nextViewButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimeConverstion.class));
            }
        });
    }


    public void convert(View v) {
        double value = new Double(dist.getText().toString());
        if(walking.isChecked()) {
            value = TimeConverter.timeWalking(value);
        } else if (boosted.isChecked()) {
            value = TimeConverter.timeBoosted(value);
        } else if (segway.isChecked()) {
            value = TimeConverter.timeSegway(value);
        } else if (evolve.isChecked()) {
            value = TimeConverter.timeEvolve(value);
        } else if (hoverboard.isChecked()) {
            value = TimeConverter.timeHoverboard(value);
        }

        //sets value back to text to show result
        time.setText(new Double(value).toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
