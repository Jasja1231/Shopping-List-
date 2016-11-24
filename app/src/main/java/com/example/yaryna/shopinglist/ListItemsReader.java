package com.example.yaryna.shopinglist;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

                Bitmap bmp = ListItemsReader.readBitmapFromFile(it.ID+".png");
                if(null != bmp)
                    it.setItemImage(bmp);
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            return null;
        }
        
        return items;
    }

    public static Bitmap readBitmapFromFile(String imageName){
        Bitmap bitmap = null;
        try{
            File sd = Environment.getExternalStorageDirectory();
            File image = new File(sd, imageName);
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
        }catch(Exception e){

        }

        return bitmap;
    }
}
