package com.example.sto13141062.flickr_viewer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button btnSearch;
    private Button btnAbout;
    private Button btnTopLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnAbout = (Button)findViewById(R.id.btnAbout);
        btnTopLocations = (Button)findViewById(R.id.btnTopLocations);




        btnSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed Search", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "pushed search button");


                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });

        btnAbout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed About", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "pushed about button");

                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });

        btnTopLocations.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed Top Locations", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "pushed locations button");

                Intent i = new Intent(MainActivity.this, TopLocations.class);
                startActivity(i);
            }
        });
    }





}