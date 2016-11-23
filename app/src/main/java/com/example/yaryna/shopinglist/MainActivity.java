package com.example.yaryna.shopinglist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * Name of the file where application stores the data for the text of the list
     */
    private final String DATA_FILE ="shoppingistData.txt";//"/data/data/com.example.yaryna.shopinglist/files/data.txt";
    private ArrayList<String> listItemsText ;
    private ListView listView;
    private ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Read values from the  file to display
         listItemsText = ListItemsReader.readFile(DATA_FILE);
        //Chek if list is empty
         if(listItemsText == null || listItemsText.isEmpty()){
            // didn't read from file
            listItemsText = new ArrayList<>();
            Snackbar.make(findViewById(R.id.content_main),"Your shopping list is empty.",4000).show();
        }
        //Add items to list view
        // ADD HERE
        listView = (ListView) findViewById(R.id.listViewItems);
        listItemsText = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItemsText);
        listView.setAdapter(itemsAdapter);
        listItemsText.add("First Item");
        listItemsText.add("Second Item");

        //Add floating button
       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //add popup to add new item to the list

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
}
