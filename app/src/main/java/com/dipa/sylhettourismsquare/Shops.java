package com.dipa.sylhettourismsquare;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dipa.adapters.RestaurantsAdapter;
import com.dipa.adapters.ShopsAdapter;
import com.dipa.models.RestaurantItem;
import com.dipa.models.ShopItem;

import java.util.ArrayList;

public class Shops extends AppCompatActivity {

    ListView listView;
    ShopsAdapter shopsAdapter;
    private ArrayList<ShopItem> itemList;
    private ShopItem shopItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prepareArrayLists();

        shopsAdapter = new ShopsAdapter(this, itemList);

        listView = (ListView) findViewById(R.id.shops_list);
        listView.setAdapter(shopsAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final ShopItem shopItem = (ShopItem) shopsAdapter.getItem(i);

                //Toast.makeText(getApplicationContext(),"You Clicked "+shopItem.getTitle(),Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Shops.this);
                alertDialog.setTitle("See: "+shopItem.getTitle()+" Location on Map?");
                alertDialog.setMessage("Press Yes to Confirm..");

                // Setting Icon to Dialog
                // alertDialog.setIcon(R.drawable.delete);

                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Shops.this,MapActivity.class);
                        intent.putExtra("latitude",shopItem.getLat());
                        intent.putExtra("longitude",shopItem.getLon());
                        intent.putExtra("location",shopItem.getTitle());
                        startActivity(intent);

                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

                        dialog.dismiss();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();


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
                    shopsAdapter.filter("");
                    listView.clearTextFilter();
                } else {
                    shopsAdapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }



    /* Method used to prepare the ArrayList,
     * Same way, you can also do looping and adding object into the ArrayList.
     */
    public void prepareArrayLists()
    {
        itemList = new ArrayList<ShopItem>();

        // Shopping Centres
        AddObjectToList("Al-Hamra Shopping City", "Zindabazar, Sylhet", "Shopping Centre", "+880821-719612", "24.897022", "91.868137");
        AddObjectToList("Blue Water Shopping City", "Zindabazar, Sylhet", "Shopping Centre", "+880821-714090","24.8949","91.8685");
        AddObjectToList("Sylhet City Centre", "Zindabazar, Sylhet", "Shopping Centre", "+880821-715787","24.895718","91.868346");
        AddObjectToList("Sylhet Millennium", "Zindabazar, Sylhet", "Shopping Centre", "+880821-721462","24.894642","91.868355");
        AddObjectToList("Gallariya Shopping Centre", "Jallarpar Road, Zindabazar, Sylhet", "Shopping Centre", "Not Found","24.894608","91.868407");
        AddObjectToList("West World Shopping City","Jallarpar Road, Zindabazar, Sylhet", "Shopping Centre", "+880821-711238","24.894668","91.867710");
        AddObjectToList("Kakoli Shopping Center","Zindabazar, Sylhet", "Shopping Centre", "+880821-717888","24.894789","91.868152");
        AddObjectToList("Manru Shopping City","Chowhatta, Sylhet", "Shopping Centre", "+880821-710121","24.899704","91.869828");
        AddObjectToList("Shukria Market","Zindabazar, Sylhet", "Shopping Centre", "Not Found","24.894406","91.869045");
        AddObjectToList("Sylhet Plaza","Zindabazar, Sylhet", "Shopping Centre", "Not Found","24.894026","91.869438");
        AddObjectToList("Mitali Mansion","Zindabazar, Sylhet", "Shopping Centre", "Not Found","24.894401","91.868447");
        AddObjectToList("Kaniz Plaza","Zindabazar, Sylhet", "Shopping Centre", "Not Found","24.895326","91.868055");
        AddObjectToList("Karimullah Market","Bondor Bazar, Sylhet", "Shopping Centre", "+880821-714555","24.891953","91.872196");

        //Fashion/Gift Shops
        AddObjectToList("Excellency Fashion House", "Kumarpara Road, Sylhet", "Clothing Store", "+880821-729041","24.898830","91.879023");
        AddObjectToList("Rich Man", "Latif Center (2nd Floor), Zindabazar, Sylhet", "Clothing Store", "+880821-720157","24.895822","91.868193");
        AddObjectToList("Ecstacsy", "Kumarpara Rd, Sylhet", "Clothing Store", "+8801928-748375","24.896112","91.878559");
        AddObjectToList("Aarong Sylhet", "Nayasarak Rd, Sylhet", "Clothing Store", "+880821-713150","24.897344","91.873384");
        AddObjectToList("Artisti Collection", "A/9 Kumarpara Rd, Sylhet", "Clothing Store", "+880821-4012094","24.895812","91.878918");
        AddObjectToList("Gents World","4/5 Wahid View, Zindabazar, Sylhet", "Clothing Store", "+8801716-469259","24.895321","91.869663");
        AddObjectToList("Gents Arts","92, Sylhet Millennium (2nd Floor), Zindabazar", "Clothing Store", "+8801711-983128","24.894593","91.867990");
        AddObjectToList("Kashish","Nayasarak Rd, Sylhet", "Clothing Store", "Not Found","24.896100","91.873148");
        AddObjectToList("Kamala Vander Mega Bazar","Nayasarak Rd, Sylhet", "Clothing Store", "Not Found","24.897043","91.873307");
        AddObjectToList("Infinity Mega Mall","Zindabazar, Sylhet", "Clothing Store", "+880162-3446677","24.895784","91.868309");
        AddObjectToList("Maha","Nayasarak Road, Sylhet", "Clothing Store", "+880821-727325","24.897341","91.873769");
        AddObjectToList("SHE - Style | Heritage | Elegance","Nayasarak Road, Sylhet", "Clothing Store", "+880821-720860","24.897651","91.874130");
        AddObjectToList("Hallmark Cards & Gift Shop","148 Manru Shopping City, Chowhatta", "Gift Shop", "+880171-1995042","24.899317","91.874895");
        //AddObjectToList("Red Card & Gift","Shahjalal Uposohor, Sylhet", "Gift Shop", "+8801747-298877","","");
        AddObjectToList("R & L Gift Shop","149 Al-Hamra Shopping City (1st Floor), Zindabazar, Sylhet", "Gift Shop", "+8801711-977511","24.897032","91.868137");
        AddObjectToList("Archies Gallery","Nayasarak Rd, Sylhet", "Gift Shop", "+8801619-430278","24.897341","91.873769");
    }

    // Add one item into the Array List
    public void AddObjectToList( String title, String address, String type, String contact, String lat, String lon)
    {
        shopItem = new ShopItem();
        shopItem.setTitle(title);
        shopItem.setAddress(address);
        shopItem.setType(type);
        shopItem.setContact(contact);
        shopItem.setLat(lat);
        shopItem.setLon(lon);
        itemList.add(shopItem);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }

}
