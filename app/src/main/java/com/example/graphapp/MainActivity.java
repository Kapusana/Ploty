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
    }

     //should be called when the user taps the edit graph button
    public void editGraph(View view) {
        Intent editIntent = new Intent(this, editGraphActivity.class);
        Button edit = (Button) findViewById(R.id.edit);
        startActivity(editIntent);
    }
}
