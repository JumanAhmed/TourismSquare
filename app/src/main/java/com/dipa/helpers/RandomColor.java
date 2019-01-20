package com.dipa.helpers;

import android.content.Context;
import android.support.v4.app.ActivityCompat;

import com.dipa.sylhettourismsquare.R;

import java.util.Random;

/**
 * Created by Shuvo on 4/6/2017.
 */

public class RandomColor {

    private static int getRandomNumber(int min,int mx){
        Random rand = new Random();
        return min + rand.nextInt((mx - min) + 1);
    }

    public static int getColor(Context context){
        int randNumber = getRandomNumber(0,10);
        switch (randNumber){
            case 0:
                return getColor(context, R.color.blue_500);
            case 1:
                return getColor(context, R.color.pink_500);
            case 2:
                return getColor(context, R.color.purple_500);
            case 3:
                return getColor(context, R.color.indigo_500);
            case 4:
                return getColor(context, R.color.cyan_500);
            case 5:
                return getColor(context, R.color.teal_500);
            case 6:
                return getColor(context, R.color.green_500);
            case 7:
                return getColor(context, R.color.yellow_500);
            case 8:
                return getColor(context, R.color.orange_500);
            case 9:
                return getColor(context, R.color.brown_500);
            default:
                return getColor(context, R.color.colorAccent);
        }
    }

    private static int getColor(Context context, int resourceId){
        return ActivityCompat.getColor(context,resourceId);
    }

}
