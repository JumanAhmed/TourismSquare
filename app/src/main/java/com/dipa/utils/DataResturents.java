package com.dipa.utils;

import com.dipa.models.RestaurantItem;
import com.dipa.sylhettourismsquare.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juman on 6/13/2017.
 */

public class DataResturents {

    public static List<RestaurantItem> getAllResturentsData(){

        List<RestaurantItem>  restaurantItems = new ArrayList<>();

        String[] title ={"Panshi Restaurant","Bhujon Bari","Shawarma House-Sylhet","Treat Gallery",
                "Nirvana Inn", "Eatopia","Mezbani,Taste of Chittagong","Kebabish Original","Chick Chicken",
                "Cafe La Vista"};

        int[] imageSmall ={R.drawable.panshi,R.drawable.bhujonbari,R.drawable.shawarma_house,
                R.drawable.treat_gallery,R.drawable.nirvana_inn,R.drawable.etopia,R.drawable.mezbani,
                R.drawable.kebabish, R.drawable.chick_chicken,R.drawable.cafe_la_vista};

        int[] imageBig ={};

        String[] cuisine={"Biryani, Budget Lunch Meals, Iftar, Kebab, Bangladeshi",
                "BBQ & Grills, Budget Lunch Meals, Iftar, Snacks, Bangladeshi",
                "Shawarma House-Sylhet", "Italian Food, Shawarma, Burgers & Fast Food",
                "Chinese Food, Iftar, Steak, Thai, Burgers & Fast Food",
                "Chinese Food, Thai",
                "BBQ & Grills, Biryani, Chinese Food, Iftar, Thai, Vegetarian, Indian",
                "Iftar, Bangladeshi",
                "Biryani, Budget Lunch Meals, Chinese Food, Indian",
                "Budget Lunch Meals, Italian Food, Pizza, Burgers & Fast Food",
                "Pizza, Thai, Burgers & Fast Food"};
        String[] contact={"+8801761-152939","+8801793-670000","+8801712-300000","+8801746-127104",
                "+880821-727640","+8801617-123321","+8801911-283059","+8801738-918314","+8801950-333222",
                "+8801978-161632"};

        String[] address={};
        String[] location={};
        String[] openCloseTime={};
        String[] parking={};
        String[] email={};
        String[] fb={};
        String[] lat={};
        String[] lon={};

        for (int i =0; i<imageSmall.length; i++){
            RestaurantItem item = new RestaurantItem();

            item.setId(i);
            item.setTitle(title[i]);
            item.setImageSmall(imageSmall[i]);
            item.setImageBig(imageBig[i]);
            item.setCuisine(cuisine[i]);
            item.setContact(contact[i]);
            item.setAddress(address[i]);
            item.setLocation(location[i]);
            item.setOpenCloseTime(openCloseTime[i]);
            item.setParking(parking[i]);
            item.setEmail(email[i]);
            item.setFb(fb[i]);
            item.setLat(lat[i]);
            item.setLon(lon[i]);

            restaurantItems.add(item);
        }


        return  restaurantItems;
    }

}
