package com.example.yaryna.shopinglist;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by Yaryna on 11/23/2016.
 */

public class Item {
   private String itemText;
    private Bitmap itemImage;
    public int  ID = -1;
    public boolean done = false;


    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Bitmap getItemImage() {
        return itemImage;
    }

    public void setItemImage(Bitmap itemImage) {
        this.itemImage = itemImage;
    }
}
