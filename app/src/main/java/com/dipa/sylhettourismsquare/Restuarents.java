package com.dipa.sylhettourismsquare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

import com.dipa.adapters.RestaurantsAdapter;
import com.dipa.models.RestaurantItem;
import com.dipa.utils.DataResturents;

import java.util.ArrayList;
import java.util.List;

public class Restuarents extends AppCompatActivity {

    ListView listView;
    RestaurantsAdapter restaurantsAdapter;
    private List<RestaurantItem> itemList;
    private RestaurantItem restaurantItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemList = DataResturents.getAllResturentsData();
        Log.e("itemList", itemList.toString());

        restaurantsAdapter = new RestaurantsAdapter(this, itemList);

        listView = (ListView) findViewById(R.id.restaurants_list);
        listView.setAdapter(restaurantsAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RestaurantItem restaurantItem = (RestaurantItem) restaurantsAdapter.getItem(i);
                Toast.makeText(getApplicationContext(),"You Clicked "+restaurantItem.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

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
                    restaurantsAdapter.filter("");
                    listView.clearTextFilter();
                } else {
                    restaurantsAdapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }



    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }
}
