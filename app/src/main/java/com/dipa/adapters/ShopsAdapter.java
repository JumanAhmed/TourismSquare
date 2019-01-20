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
import android.widget.Toast;

import com.dipa.models.ShopItem;
import com.dipa.sylhettourismsquare.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Shuvo on 6/11/2017.
 */

public class ShopsAdapter extends BaseAdapter {

    ArrayList<ShopItem> itemList;
    private List<ShopItem> searchList;

    public Activity context;
    public LayoutInflater inflater;
    private int lastPosition = -1;

    public ShopsAdapter(Activity context,ArrayList<ShopItem> itemList) {
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
        TextView txtViewTitle;
        TextView txtViewAddress;
        TextView txtViewContact;
        TextView txtViewType;
        CardView cardView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        //create the view result for showing the animation
        final View result;

        final ShopsAdapter.ViewHolder holder;
        if(convertView==null)
        {
            holder = new ShopsAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.shops_row, null);

            //holder.imgViewLogo = (ImageView) convertView.findViewById(R.id.shop_image);
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.shop_title);
            holder.txtViewType = (TextView) convertView.findViewById(R.id.shop_type);
            holder.txtViewAddress = (TextView) convertView.findViewById(R.id.shop_address);
            holder.txtViewContact = (TextView) convertView.findViewById(R.id.shop_contact);
            holder.cardView = (CardView) convertView.findViewById(R.id.cardView);

            result = convertView;

            convertView.setTag(holder);
        }
        else {
            holder = (ShopsAdapter.ViewHolder) convertView.getTag();
            result =convertView;
        }

        final ShopItem shopItem = (ShopItem) itemList.get(position);


        holder.txtViewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String check = holder.txtViewContact.getText().toString();
                if(!check.equalsIgnoreCase("Not Found"))
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String tmp = "tel:" + shopItem.getContact().toString();
                    intent.setData(Uri.parse(tmp));
                    context.startActivity(intent);
                }
                else
                {
                    Toast.makeText(context,"Contact No not found",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


        // Animation effect part
        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        //holder.imgViewLogo.setImageResource(shopItem.getImage());
        holder.txtViewTitle.setText(shopItem.getTitle());
        holder.txtViewType.setText(shopItem.getType());
        holder.txtViewAddress.setText(shopItem.getAddress());
        holder.txtViewContact.setText(shopItem.getContact());
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
            for (ShopItem s : searchList) {
                if (s.getTitle().toLowerCase(Locale.getDefault()).contains(charText)
                        || s.getType().toLowerCase(Locale.getDefault()).contains(charText)
                        || s.getAddress().toLowerCase(Locale.getDefault()).contains(charText)) {
                    itemList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }
}