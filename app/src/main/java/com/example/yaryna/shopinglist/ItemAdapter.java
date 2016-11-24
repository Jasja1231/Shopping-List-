package com.example.yaryna.shopinglist;

import android.content.Context;
import android.media.Image;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaryna Konyushenko on 11/23/2016.
 */

public class ItemAdapter  extends ArrayAdapter<Item> {

    private ArrayList<Item> itemsList;
    private static LayoutInflater inflater = null;

    public ItemAdapter(Context c, List<Item> items) {
        super(c, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView itemView = (ItemView)convertView;
        if (null == itemView)
            itemView = ItemView.inflate(parent);

        itemView.setItem(getItem(position));
        return itemView;
    }

}

