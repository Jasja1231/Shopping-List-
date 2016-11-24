package com.example.yaryna.shopinglist;

import android.media.Image;

/**
 * Created by Yaryna on 11/23/2016.
 */

public class Item {
   private String itemText;
   private  Image itemImage;
    public int  ID = -1;


    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Image getItemImage() {
        return itemImage;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage = itemImage;
    }
}
