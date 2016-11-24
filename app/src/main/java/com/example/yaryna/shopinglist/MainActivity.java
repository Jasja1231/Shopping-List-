package com.example.yaryna.shopinglist;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Name of the file where application stores the data for the text of the list
     */
    private final String DATA_FILE ="shoppingistData.txt";//"/data/data/com.example.yaryna.shopinglist/files/data.txt";

    private ArrayList<Item> items ;


    private ListView listView;
    private ItemAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Read values from the  file to display
        items = ListItemsReader.readFile(DATA_FILE);

        //Chek if list is empty
         if(items == null || items.isEmpty()){
            // didn't read from file
            items = new ArrayList<>();
            Snackbar.make(findViewById(R.id.content_main),"Your shopping list is empty.",4000).show();
        }

        //Add items to list view
        listView = (ListView) findViewById(R.id.listViewItems);

        itemListAdapter = new ItemAdapter(this,items);
        listView.setAdapter(itemListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item itt = itemListAdapter.getItem(position);
                final AddItemDialog dialog = new AddItemDialog(MainActivity.this);
                dialog.setContentView(R.layout.add_item_view);
                dialog.setTitle("Edit item");
                dialog.setItem(itt);
                Button cancelButton = (Button)dialog.findViewById(R.id.button_cancel);
                cancelButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button saveButton = (Button)dialog.findViewById(R.id.button_save);
                saveButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.addItem(dialog.getConstructedItem());
                        dialog.dismiss();
                    }
                });
                Button deleteButton = (Button)dialog.findViewById(R.id.button_delete);
                deleteButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.deleteItem(dialog.getConstructedItem());
                        dialog.dismiss();
                    }
                });


                dialog.show();

            }
        });


        //Add floating button
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //add popup to add new item to the list
                final AddItemDialog dialog = new AddItemDialog(MainActivity.this);
                dialog.setContentView(R.layout.add_item_view);
                dialog.setTitle("Add item");
                Button cancelButton = (Button)dialog.findViewById(R.id.button_cancel);
                cancelButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Button saveButton = (Button)dialog.findViewById(R.id.button_save);
                saveButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.addItem(dialog.getConstructedItem());
                        dialog.dismiss();
                    }
                });
                Button deleteButton = (Button)dialog.findViewById(R.id.button_delete);
                deleteButton.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addItem(Item it) {
        if(it.ID == -1){
            //new item
            it.ID = this.items.size();
            items.add(it);
        }
        else{
            items.set(it.ID,it);
        }
        //Add items to list view
        listView.invalidate();
        listView = (ListView) findViewById(R.id.listViewItems);
        itemListAdapter = new ItemAdapter(this,items);
        listView.setAdapter(itemListAdapter);
    }

    public void deleteItem(Item it){
      items.remove(it);
        for(int i = 0 ; i < items.size();i++){
            items.get(i).ID = i;
        }
        //Add items to list view
        listView.invalidate();
        listView = (ListView) findViewById(R.id.listViewItems);
        itemListAdapter = new ItemAdapter(this,items);
        listView.setAdapter(itemListAdapter);
    }
}
