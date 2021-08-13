package com.example.airpollution;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class dataReader {
    String allData;
   // TextView txtView;


    public String getAllData() {
        return allData;
    }

    public void readFile(Context context, String file)
    {

       // txtView = ((Activity)context).findViewById(R.id.txtView);
        try
        {
            InputStream is = context.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            allData = new String(buffer);
            removeFirstRows();
        }
        catch (IOException e)
        {
            try {
                InputStream is = context.getAssets().open("default.csv");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();

                allData = new String(buffer);
                removeFirstRows();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void removeFirstRows()
    {
        char[] charSet = allData.toCharArray();
        int k = charSet.length;
        int counter = 0;
        int i;
        for(i = 0; i < k; i++)
        {
            if(charSet[i] == '\n') counter++;
            if(counter == 3) break;
        }
        i++;
        char[] newStr = new char[k - i];
        System.arraycopy(charSet, i, newStr, 0, k-i);
        allData = new String(newStr);
    }
}
