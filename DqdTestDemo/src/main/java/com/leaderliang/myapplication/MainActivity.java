package com.leaderliang.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;

/**
 * @author liangyanqiao
 */
public class MainActivity extends AppCompatActivity {


    private CircleProgressView mCircleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_progress);



        mCircleBar = (CircleProgressView) findViewById(R.id.circleProgressbar);

        mCircleBar.setTopTxt("已抢");
        mCircleBar.setProgress(90);

        final String str = "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";

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap mBitmap =  stringtoBitmap(str);
            }
        }).start();


    }


    public Bitmap stringtoBitmap(String string){
        //将字符串转换成Bitmap类型
        Bitmap bitmap=null;
        try {
            byte[]bitmapArray;
            bitmapArray= Base64.decode(string, Base64.DEFAULT);
            bitmap= BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

}
