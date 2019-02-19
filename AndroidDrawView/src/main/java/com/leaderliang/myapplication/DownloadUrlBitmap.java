package com.leaderliang.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class DownloadUrlBitmap {


    private Bitmap downloadUrlBitmap(String str){

        Bitmap bitmap = null;
        HttpURLConnection connection = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            URL url = new URL(URLEncoder.encode(str));
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            bufferedInputStream = new BufferedInputStream(connection.getInputStream(), 8 * 1024);
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);


        } catch (final IOException e) {
            e.printStackTrace();
        }
        finally{
            if(connection != null){
                connection.disconnect();
            }
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return bitmap;
    }
}
