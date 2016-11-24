package com.example.yaryna.shopinglist;

import android.app.Application;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Yaryna Konyushenko on 11/23/2016.
 */

public class ListItemsReader {

    /**
     *
     * @param fileName the name of the file to be loaded from the memory
     * @return null - if anu error occured. Fie may not exist.
     */
    public static  ArrayList<Item>  readFile(String fileName ){
        ArrayList<Item> items = new ArrayList<Item>();

        //find the directory for the SDcard
        File dir = Environment.getExternalStorageDirectory();
        //Get the text file with iist items
        File file = new File(dir,fileName);

        try {

            if(!file.exists()){
                file.createNewFile();
                return items;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            int index = 0;
            while ((line = br.readLine()) != null) {
                Item it = new Item();
                it.setItemText(line);
                it.ID = index;
                items.add(it);
                index++;
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            return null;
        }
        
        return items;
    }
}
