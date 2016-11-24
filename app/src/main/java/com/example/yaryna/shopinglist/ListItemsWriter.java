package com.example.yaryna.shopinglist;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.R.attr.path;

/**
 * Created by Yaryna Konyushenko on 11/24/2016.
 */

public class ListItemsWriter {

    public static void writeImageToFile(String filename,Bitmap bmp){
        FileOutputStream out = null;
        try {
            File sd = Environment.getExternalStorageDirectory();
            out = new FileOutputStream(sd.getPath() + "/" +filename);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteImage(String filename){

        try {
            File sd = Environment.getExternalStorageDirectory();
            File b = new File(sd,filename);
            boolean deleted = b.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Renames image file.
     * @param oldFileName
     * @param newName
     */
    public static void renameImage(String oldFileName,String newName){
        try {
            File sd = Environment.getExternalStorageDirectory();
            File from = new File(sd,oldFileName);
            File to = new File(sd,newName);

            if(from.exists())
                from.renameTo(to);

        } catch (Exception e) {
        }
    }

    /**
     * Writes text list to a file
     * @param data
     */
    public static void writeToFile(String data)
    {
        // Get the directory for the user's public pictures directory.
        File sd = Environment.getExternalStorageDirectory();
        File file = new File(sd, "shoppingistData.txt");
        try
        {
            FileOutputStream fOut = new FileOutputStream(file,false);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();

            fOut.flush();
            fOut.close();
        }
        catch (IOException e)
        {
        }
    }
}
