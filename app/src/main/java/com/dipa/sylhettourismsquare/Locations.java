package com.dipa.sylhettourismsquare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dipa.adapters.LocationsAdapter;
import com.dipa.models.LocationItem;
import com.dipa.utils.DataUtils;

import java.util.List;

public class Locations extends AppCompatActivity{

    private LocationsAdapter adapter;
    private List<LocationItem> items;
    private ListView locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        locations = (ListView) findViewById(R.id.locations_list);
        items = DataUtils.getLocations(this);
        Log.e("itemList", items.toString());
        adapter = new LocationsAdapter(this,items);
        locations.setAdapter(adapter);
        locations.setTextFilterEnabled(true);

        locations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LocationItem item = (LocationItem) parent.getItemAtPosition(position);
                Intent intent = new Intent(Locations.this,SingleLocation.class);
                intent.putExtra("locationName",item.getPlaceName());
                intent.putExtra("locationInformationEn",item.getDescriptionEnglish());
                intent.putExtra("locationInformationBn",item.getDescriptionBengali());
                intent.putExtra("locationLatitude",item.getLat());
                intent.putExtra("locationLongitude",item.getLon());
                intent.putExtra("loc_id",item.getId());
                intent.putExtra("distance",item.getDistance());

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.menu_search, menu);

        MenuItem myActionMenuItem = menu.findItem( R.id.search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    locations.clearTextFilter();
                } else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }
}
