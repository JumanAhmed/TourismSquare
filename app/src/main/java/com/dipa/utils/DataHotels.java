package com.dipa.utils;

import com.dipa.models.HotelItem;
import com.dipa.sylhettourismsquare.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juman on 6/20/2017.
 */

public class DataHotels {

    public static List<HotelItem> getAllHotelData(){

        List<HotelItem>  hotelItems = new ArrayList<>();


        String[] name ={"Rose View Hotel","Hotel Star Pacific","Nirvana Inn","Hotel Supreme","Hotel Garden Inn",
                "Richmond Hotel & Apartments","Hotel Holy Gate","Holy Complex","Hotel Noorjahan Grand",
                "La Rose Hotel"};

        String[] location={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};

        String[] address ={"Shahjalal Uposhohor, Sylhet","East Dorga Gate, Sylhet","Mirzajangal, Sylhet",
                "East Mirabazar, Sylhet","Garden Tower, Shahjalal Bridge Link Road, Sylhet",
                "10th Floor, Al Hamra Shopping City, Zindabazar, Sylhet","East Dargah Gate, Sylhet",
                "Waves 1, Ritz Tower, Dargah Gate, Sylhet","16 Ornob, West Dorga Gate, Mirer Moidan Point, Sylhet",
                "B-95 Waves, Shahjalal Road, Ambarkhana Sylhet"};

        String[] contact = {"+880821-721835","+880821-727945","+880821-727640","+880821-710897","+880821-727284",
                "+880821-719076","+8801972-552233","+8801930-111666","+8801966-616661","+880821-711013"};

        int[] imageLogo={R.drawable.rose_view,R.drawable.star_pacific,R.drawable.nirvana_inn_hotel,
                R.drawable.hotel_supreme,R.drawable.hotel_garden_inn,R.drawable.richmond_hotel,
                R.drawable.hotel_holy_gate,R.drawable.hotel_noorjahan_grand,R.drawable.la_rose_hotel,
                R.drawable.britania_hotel};

        String[] email={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};
        String[] fb ={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};
        String[] wifi={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};
        String[] lat={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};
        String[] lon={"yes","yes","yes","yes","yes","yes","yes","yes","yes","yes"};

        int[] slideImage1 = {R.drawable.panthumai_01,R.drawable.bholagonj_01,R.drawable.bisanakandi_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01};
        int[] slideImage2 = {R.drawable.panthumai_01,R.drawable.bholagonj_01,R.drawable.bisanakandi_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01};
        int[] slideImage3 = {R.drawable.panthumai_01,R.drawable.bholagonj_01,R.drawable.bisanakandi_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01,R.drawable.bisanakandi_01,R.drawable.panthumai_01,
                R.drawable.bisanakandi_01};



        for (int i =0; i<name.length; i++){
            HotelItem item = new HotelItem();

            item.setName(name[i]);
            item.setLocation(location[i]);
            item.setAddress(address[i]);
            item.setContact(contact[i]);
            item.setImageLogo(imageLogo[i]);
            item.setEmail(email[i]);
            item.setFb(fb[i]);
            item.setWifi(wifi[i]);
            item.setLat(lat[i]);
            item.setLon(lon[i]);

            ArrayList<HotelItem.Slider> sliders = new ArrayList<>();
            for (int j=i; j<i+1; j++){
                HotelItem.Slider sliderItem = new HotelItem.Slider();

                sliderItem.setImage(slideImage1[j]);
                sliderItem.setImage(slideImage2[j]);
                sliderItem.setImage(slideImage3[j]);

                sliders.add(sliderItem);
            }
            item.setImageSlider(sliders);

            hotelItems.add(item);

        }


        return  hotelItems;
    }
    
}
