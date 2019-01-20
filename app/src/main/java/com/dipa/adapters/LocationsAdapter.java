package com.dipa.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dipa.helpers.RandomColor;
import com.dipa.models.LocationItem;
import com.dipa.sylhettourismsquare.Locations;
import com.dipa.sylhettourismsquare.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shuvo on 3/27/2017.
 */

public class LocationsAdapter extends ArrayAdapter<LocationItem> {

    private String TAG = "ADAPTER";

    private final Context context;
    private final List<LocationItem> items;
    private List<LocationItem> searchList;


    public LocationsAdapter(Context context, List<LocationItem> items) {
        super(context, R.layout.activity_locations, items);
        this.context = context;
        this.items = items;
        this.searchList = new ArrayList<>();
        this.searchList.addAll(items);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public LocationItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        private TextView placeName;
        private TextView placeDistrict;
        private CardView cardView;
        private ImageView imageView;

        ViewHolder(View view) {
            placeName = (TextView) view.findViewById(R.id.location_name);
            placeDistrict = (TextView) view.findViewById(R.id.location_district);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imageView = (ImageView) view.findViewById(R.id.location_image);
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;


        View rowView = convertView;

        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.locations_row, parent, false);
            viewHolder = new ViewHolder(rowView);


            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();

        }


        viewHolder.placeName.setText(items.get(position).getPlaceName());
        viewHolder.imageView.setImageResource(items.get(position).getDrawableImage());
        viewHolder.placeDistrict.setText(items.get(position).getDistance()+" KM from Sylhet City");
        //viewHolder.cardView.setCardBackgroundColor(RandomColor.getColor(context));
        return rowView;
    }


    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if (charText.length() == 0) {
            items.addAll(searchList);
        } else {
            for (LocationItem s : searchList) {
                if (s.getPlaceName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    items.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }
}
