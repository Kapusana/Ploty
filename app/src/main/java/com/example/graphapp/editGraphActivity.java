package com.example.graphapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editGraphActivity extends AppCompatActivity {
    //constants used to initialize EXTRA in intents
    public static final String EXTRA_X1 = "com.example.GraphApp.x1";
    public static final String EXTRA_Y1 = "com.example.GraphApp.y1";
    public static final String EXTRA_X2 = "com.example.GraphApp.x2";
    public static final String EXTRA_Y2 = "com.example.GraphApp.y2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_graph);
    }

    //Testing how intents will work with int in put Extra, not sure about 'default value'
    public void editGraph(View view) {
        Intent plotIntent = new Intent(this, MainActivity.class);
        Button plot = (Button) findViewById(R.id.plot);

        EditText x1 = (EditText) findViewById(R.id.x1);
        EditText y1 = (EditText) findViewById(R.id.y1);
        EditText x2 = (EditText) findViewById(R.id.x2);
        EditText y2 = (EditText) findViewById(R.id.y2);

//        might need to add this line
//        String message = editText.getText().toString();

        //*****mind how to work on this in other activity
        plotIntent.putExtra(EXTRA_X1, (Parcelable) x1);
        plotIntent.putExtra(EXTRA_Y1, (Parcelable) y1 );
        plotIntent.putExtra(EXTRA_X2, (Parcelable) x2 );
        plotIntent.putExtra(EXTRA_Y2, (Parcelable) y2 );
        startActivity(plotIntent);
    }
}
