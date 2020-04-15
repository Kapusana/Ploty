package com.example.graphapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***Create onClickListener when confirm plot -> get intents,plot graph
        Button confirmPlot = (Button) findViewById(R.id.confirmPlot);
        confirmPlot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //getting intent
                Intent plotIntent = getIntent();
                /* Edit this to int form *********
                String x1 = plotIntent.getStringExtra(editGraphActivity.EXTRA_X1);

            }
        }); */
    }

    //When switching to scrollView remove the lines below


     //should be called when the user taps the edit graph button
//    public void editGraph(View view) {
//        Intent editIntent = new Intent(this, editGraphActivity.class);
//        Button edit = (Button) findViewById(R.id.edit);
//        startActivity(editIntent);
//    }
}
