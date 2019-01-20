package com.dipa.sylhettourismsquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dipa.adapters.HotelsAdapter;
import com.dipa.models.HotelItem;
import com.dipa.utils.DataHotels;

import java.util.List;

public class Hotels extends AppCompatActivity {

    public ListView listView;
    public HotelsAdapter hotelsAdapter;
    public List<HotelItem> itemList;
    public HotelItem hotelItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemList = DataHotels.getAllHotelData();
        hotelsAdapter = new HotelsAdapter(this, itemList);

        listView = (ListView) findViewById(R.id.hotels_list);
        listView.setAdapter(hotelsAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                HotelItem hotelItem = (HotelItem) adapterView.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), SingleHotel.class);

                intent.putExtra("name", hotelItem.getName());
                intent.putExtra("address", hotelItem.getAddress());

                //intent.putIntegerArrayListExtra("jaki", hotelItem.getImageSlider());

                //Log.e("name", hotelItem.getName());
                //Log.e("address", hotelItem.getAddress());




                startActivity(intent);

                //HotelItem hotelItem = (HotelItem) hotelsAdapter.getItem(i);
                //Toast.makeText(getApplicationContext(),"You Clicked "+hotelItem.getName(),Toast.LENGTH_SHORT).show();
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
                    hotelsAdapter.filter("");
                    listView.clearTextFilter();
                } else {
                    hotelsAdapter.filter(newText);
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
