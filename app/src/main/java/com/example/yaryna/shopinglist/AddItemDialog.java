package com.example.yaryna.shopinglist;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Yaryna Konyushenko on 11/24/2016.
 */


public class AddItemDialog extends Dialog{
    /**
     * UI elements
     */
    private View view;
    private EditText itemTextView;
    private Button cancelButton, saveButton,takePictureButton,deleteButton;
    public MainActivity mainActivity;

    /**
     * Data
     */
    private int ID;
    public Item item;

    /**
     * Creates a dialog window that uses the default dialog theme.
     * <p>
     * The supplied {@code context} is used to obtain the window manager and
     * base theme used to present the dialog.
     *
     * @param context the context in which the dialog should run
     * @see android.R.styleable#Theme_dialogTheme
     */
    public AddItemDialog(Context context) {
        super(context);
       item = new Item();
    }

    public void setItem(Item oldItem){
        EditText itemTextView  = (EditText) this.findViewById(R.id.itemEditNameText);
        itemTextView.setText(oldItem.getItemText());
        this.item = oldItem;
    }

    private void initButtons(){
        //TODO: delete this function

        Button saveButton = (Button)view.findViewById(R.id.button_save);
        Button cancelButton = (Button)this.findViewById(R.id.button_cancel);
        Button deleteButton = (Button)this.findViewById(R.id.button_delete);
        Button takePictureButton = (Button) this.findViewById(R.id.button_add_image);
        saveButton.setOnClickListener(new Button.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                AddItemDialog.this.mainActivity.addItem(AddItemDialog.this.getConstructedItem());
            }
        });

    }

    public void setMainActivity(MainActivity m){
            this.mainActivity = m;
    }

    public Item getConstructedItem(){
        EditText itemTextView  = (EditText) this.findViewById(R.id.itemEditNameText);
        this.item.setItemText(itemTextView.getText().toString());

        //TODO: handle image
        return this.item;
    }


    public void acceptImage(Bitmap lastLoaded) {
        this.item.setItemImage(lastLoaded);
    }
}
