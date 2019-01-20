package com.dipa.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dipa.models.HotelItem;
import com.dipa.sylhettourismsquare.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shuvo on 6/9/2017.
 */

public class HotelsAdapter extends BaseAdapter {


    public List<HotelItem> itemList;
    private List<HotelItem> searchList;

    public Activity context;
    public LayoutInflater inflater;

    private int lastPosition = -1;

    public HotelsAdapter(Activity context, List<HotelItem> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;
        this.searchList = new ArrayList<>();
        this.searchList.addAll(itemList);

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public static class ViewHolder
    {
        ImageView imgViewLogo;
        TextView txtViewName;
        TextView txtViewAddress;
        TextView txtViewContact;
        CardView cardView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        //create the view result for showing the animation
        final View result;

        final HotelsAdapter.ViewHolder holder;
        if(convertView==null)
        {
            holder = new HotelsAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.hotels_row, null);

            holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.hotel_image);
            holder.txtViewName = (TextView) convertView.findViewById(R.id.hotel_title);
            holder.txtViewAddress = (TextView) convertView.findViewById(R.id.hotel_address);
            holder.txtViewContact = (TextView) convertView.findViewById(R.id.hotel_contact);
            holder.cardView = (CardView) convertView.findViewById(R.id.cardView);

            result = convertView;

            convertView.setTag(holder);
        }
        else {
            holder = (HotelsAdapter.ViewHolder) convertView.getTag();

            result = convertView;
        }

        final HotelItem hotelItem = (HotelItem) itemList.get(position);


        holder.txtViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String tmp = "tel:" + hotelItem.getContact().toString();
                intent.setData(Uri.parse(tmp));
                context.startActivity(intent);
            }
        });

        // Animation effect part
        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.imgViewLogo.setImageResource(hotelItem.getImageLogo());
        holder.txtViewName.setText(hotelItem.getName());
        holder.txtViewAddress.setText(hotelItem.getAddress());
        holder.txtViewContact.setText(hotelItem.getContact());
        //holder.cardView.setCardBackgroundColor(RandomColor.getColor(context));
        return convertView;
    }

    // Filter method
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        itemList.clear();
        if (charText.length() == 0) {
            itemList.addAll(searchList);
        } else {
            for (HotelItem s : searchList) {
                if (s.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    itemList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }
}
