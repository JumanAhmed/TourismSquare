package com.dipa.utils;

import android.content.Context;

import com.dipa.models.LocationItem;
import com.dipa.sylhettourismsquare.R;

import java.util.ArrayList;

/**
 * Created by Shakib on 3/27/2017.
 */

public class DataUtils {

    public static ArrayList<LocationItem> getLocations(Context context)
    {
        ArrayList<LocationItem> items = new ArrayList<>();

        String[] locationsName = getLocationsName(context);
        String[] locationDetailsBengali = getLocationsDescriptionBengali(context);
        String[] locationDetailsEnglish = getLocationsDescriptionEnglish(context);
        String[] locationLatitude = getLocationLatitude(context);
        String[] locationLongitude = getLocationLongitude(context);
        int[] locationsDistances = getLocationsDistances(context);
        //int[] locationDrawableImage = getLocationImage(context);
        int [] locationDrawableImage = {
                R.drawable.bholagonj_01,
                R.drawable.bisanakandi_01,
                R.drawable.dolura_01,
                R.drawable.jadukata_00,
                R.drawable.jaflong_01,
                R.drawable.khadim_rainforest_01,
                R.drawable.lalakhal_00,
                R.drawable.lawachora_01,
                R.drawable.lovachora_01,
                R.drawable.panthumai_01,
                R.drawable.ratargul_05,
                R.drawable.rema_kalenga_01,
                R.drawable.sathchori_00,
                R.drawable.tang01,
                R.drawable.sreemongol,
                R.drawable.shajalamajar,
                R.drawable.ham_ham_waterfall
        };

        int len = locationsName.length;

        for(int i=0;i<len;i++){
            LocationItem item = LocationItem.builder()
                    .withId(i)
                    .withPlaceName(locationsName[i])
                    .withDescriptionBengali(locationDetailsBengali[i])
                    .withDescriptionEnglish(locationDetailsEnglish[i])
                    .withDistance(locationsDistances[i])
                    .withDrawableImage(locationDrawableImage[i])
                    .withLatitude(locationLatitude[i])
                    .withLongitude(locationLongitude[i])
                    .build();
            items.add(item);
        }

        return items;
    }

    public static int[] getLocationImage(Context context) {
        return context.getResources().getIntArray(R.array.locations_images);
    }

    private static String[] getLocationsName(Context context){
        return context.getResources().getStringArray(R.array.locations_name);
    }

    private static String[] getLocationsDescriptionBengali(Context context){
        return context.getResources().getStringArray(R.array.location_details_bengli);
    }

    private static String[] getLocationsDescriptionEnglish(Context context){
        return context.getResources().getStringArray(R.array.locations_details_english);
    }

    private static int[] getLocationsDistances(Context context){
        return context.getResources().getIntArray(R.array.locations_distances);
    }

    private static String[] getLocationLatitude(Context context){
        return context.getResources().getStringArray(R.array.locations_latitude);
    }
    private static String[] getLocationLongitude(Context context){
        return context.getResources().getStringArray(R.array.locations_longitude);
    }

}
