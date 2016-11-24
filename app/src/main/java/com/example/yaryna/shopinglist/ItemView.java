package com.example.yaryna.shopinglist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Yaryna Konyushenko on 11/23/2016.
 */

/**
 * ItemView is responsible for translating an
 * Item into views to render onscreen.
 */

public class ItemView extends RelativeLayout {
    private TextView mDescriptionTextView;
    private ImageView imageView;
    private CheckBox doneCheck;

    public static ItemView inflate(ViewGroup parent) {
        ItemView itemView = (ItemView)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return itemView;
    }

    public ItemView(Context c) {
        this(c, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(R.layout.item_view_children, this, true);
        setupChildren();
    }

    private void setupChildren() {
        mDescriptionTextView = (TextView) findViewById(R.id.item_textView);
        imageView = (ImageView) findViewById(R.id.item_imageView);
        doneCheck = (CheckBox) findViewById(R.id.done_checkBox);
    }

    public void setItem(Item item) {
        mDescriptionTextView.setText(item.getItemText());
        // TODO: set up image URL
        if(null == item.getItemImage())
            this.imageView.setVisibility(View.INVISIBLE);

        if(item.done == true)
            this.doneCheck.setChecked(true);
            
    }

    public ImageView getImageView () {
        return imageView;
    }


    public TextView getDescriptionTextView() {
        return mDescriptionTextView;
    }
}