package com.example.yaryna.shopinglist;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
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
    private Item item;

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
        initButtons();
    }


    public void initButtons(){
        final EditText itemTextView  = (EditText) this.findViewById(R.id.editText);

        Button saveButton = (Button)view.findViewById(R.id.button_save);
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
        Button cancelButton = (Button)this.findViewById(R.id.button_cancel);
        Button deleteButton = (Button)this.findViewById(R.id.button_delete);
        Button takePictureButton = (Button) this.findViewById(R.id.button_add_image);
    }
    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
   // @Override
   /* public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_item_view, container, false);

        initButtons();
        return view;
    }*/


    public void setMainActivity(MainActivity m){
            this.mainActivity = m;
    }

    public Item getConstructedItem(){

        return this.item;
    }

}
