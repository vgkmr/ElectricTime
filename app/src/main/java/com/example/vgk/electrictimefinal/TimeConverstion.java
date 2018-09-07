package com.example.vgk.electrictimefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class TimeConverstion extends AppCompatActivity {

    EditText ogTime;
    EditText newTime;
    RadioButton walking;
    RadioButton boosted;
    RadioButton segway;
    RadioButton evolve;
    RadioButton hoverboard;

    RadioButton walking2;
    RadioButton boosted2;
    RadioButton segway2;
    RadioButton evolve2;
    RadioButton hoverboard2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_converstion);
        ogTime = (EditText)findViewById(R.id.ogTimeEditText);
        newTime = (EditText)findViewById(R.id.newTimeEditText);

        walking = (RadioButton)findViewById(R.id.walkingradioButton);
        boosted = (RadioButton)findViewById(R.id.boostedradioButton);
        segway = (RadioButton)findViewById(R.id.segwayradioButton);
        evolve = (RadioButton)findViewById(R.id.evolveradioButton);
        hoverboard = (RadioButton)findViewById(R.id.hoverboardradioButton);

        walking2 = (RadioButton)findViewById(R.id.walkingradioButton2);
        boosted2 = (RadioButton)findViewById(R.id.boostedradioButton2);
        segway2 = (RadioButton)findViewById(R.id.segwayradioButton2);
        evolve2 = (RadioButton)findViewById(R.id.evolveradioButton2);
        hoverboard2 = (RadioButton)findViewById(R.id.hoverboardradioButton2);

        configureBackBUtton();
    }

    private void configureBackBUtton(){
        Button backButton = findViewById(R.id.backViewButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void convert(View v) {

        double value = new Double(ogTime.getText().toString());


        //translate time back into distance
        if(walking.isChecked()) {
            value = TimeConverter.walkingTime(value);
        } else if (boosted.isChecked()) {
            value = TimeConverter.boostedTime(value);
        } else if (segway.isChecked()) {
            value = TimeConverter.segwayTime(value);
        } else if (evolve.isChecked()) {
            value = TimeConverter.evolveTime(value);
        } else if (hoverboard.isChecked()) {
            value = TimeConverter.hoverboardTime(value);
        }

        //translate distance into back into time for another method of transport
        if(walking2.isChecked()) {
            value = TimeConverter.timeWalking(value);
        }
        else if(boosted2.isChecked()) {
            value = TimeConverter.timeBoosted(value);
        }
        else if(segway2.isChecked()) {
            value = TimeConverter.timeSegway(value);
        }
        else if(evolve2.isChecked()) {
            value = TimeConverter.timeEvolve(value);
        }
        else if(hoverboard2.isChecked()) {
            value = TimeConverter.timeHoverboard(value);
        }


        //sets value back to text to show result
        newTime.setText(new Double(value).toString());
    }
}
