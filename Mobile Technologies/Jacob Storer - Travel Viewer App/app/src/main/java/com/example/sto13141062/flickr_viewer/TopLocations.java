package com.example.sto13141062.flickr_viewer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TopLocations extends ActionBarActivity {

    private ListView listLocations;

    private List<TopLocationObject> topLocations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_locations);


    listLocations = (ListView)findViewById(R.id.listLocations);

       // Cities = new ArrayList<String>();

        topLocations = new ArrayList<TopLocationObject>();


        topLocations.add( new TopLocationObject("Beijing", "China", R.drawable.china, "https://upload.wikimedia.org/wikipedia/commons/9/95/BeijingWatchTower.jpg"));
        topLocations.add( new TopLocationObject("London", "England", R.drawable.england, "https://upload.wikimedia.org/wikipedia/commons/b/b6/Tower_of_london_from_swissre.jpg"));
        topLocations.add( new TopLocationObject("Paris", "France", R.drawable.france, "https://upload.wikimedia.org/wikipedia/commons/c/c7/HotelVilleParis.JPG"));
        topLocations.add( new TopLocationObject("Berlin", "Germany", R.drawable.germany,"https://upload.wikimedia.org/wikipedia/commons/5/53/%C3%9Cber_den_D%C3%A4chern_von_Berlin.jpg"));
        topLocations.add( new TopLocationObject("New York", "United States of America", R.drawable.unitedstates, "https://upload.wikimedia.org/wikipedia/commons/d/d3/Statue_of_Liberty%2C_NY.jpg"));
        topLocations.add( new TopLocationObject("Madrid", "Spain", R.drawable.spain, "https://upload.wikimedia.org/wikipedia/commons/f/f3/Palacio_de_Comunicaciones_-_07.jpg"));
        topLocations.add( new TopLocationObject("Stockholm", "Sweden", R.drawable.sweden,"https://upload.wikimedia.org/wikipedia/commons/7/78/Kistacentralparts_Publish.jpg"));
        topLocations.add( new TopLocationObject("Sydney", "Australia", R.drawable.australia,"https://upload.wikimedia.org/wikipedia/commons/2/27/City_of_sydney_from_the_balmain_wharf_dusk_cropped2.jpg"));
        topLocations.add( new TopLocationObject("Tokyo", "Japan", R.drawable.japan, "https://upload.wikimedia.org/wikipedia/commons/1/12/TokyoMetropolitanGovernmentOffice.jpg"));
        topLocations.add( new TopLocationObject("Moscow", "Russia", R.drawable.russia, "https://upload.wikimedia.org/wikipedia/commons/d/db/Russie_-_Moscou_-_Novodevichy_4.jpg"));


        LocationAdapter adapter = new LocationAdapter(topLocations);

        listLocations.setAdapter(adapter);

        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("FLICKR_TAG", "clicked on = " + position);

                Intent i = new Intent(TopLocations.this, SpecificLocationActivity.class);

                i.putExtra("EXTRA_TOP_LOCATION", topLocations.get(position));

                startActivity(i);
            }
        });

    }



    private class LocationAdapter extends ArrayAdapter<TopLocationObject> {

        public LocationAdapter(List<TopLocationObject> items) {
            super(TopLocations.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.locations_layout, null);
            }

            ImageView CountryFlag = (ImageView)convertView.findViewById(R.id.CountryFlag);
            TextView CityName = (TextView)convertView.findViewById(R.id.CityName);
            TextView CountryName = (TextView)convertView.findViewById(R.id.CountryName);


            TopLocationObject LocationInfo = topLocations.get(position);


            CountryFlag.setImageResource(LocationInfo.getFlagResource());
            CityName.setText(LocationInfo.getCityName());
            CountryName.setText(LocationInfo.getCountryName());

            return convertView;
        }// end get view

    }// end adapter class


}
