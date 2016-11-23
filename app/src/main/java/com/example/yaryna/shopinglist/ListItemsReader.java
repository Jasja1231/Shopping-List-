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
    public static ArrayList<String> readFile(String fileName ){
        ArrayList<String> listOfItems = new ArrayList<String>();

        //find the directory for the SDcard
        File dir = Environment.getExternalStorageDirectory();
        //Get the text file with iist items
        File file = new File(dir,fileName);

        try {

            if(!file.exists()){
                file.createNewFile();
                return listOfItems;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                listOfItems.add(line);
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            return null;
        }
        
        return listOfItems;
    }
}
