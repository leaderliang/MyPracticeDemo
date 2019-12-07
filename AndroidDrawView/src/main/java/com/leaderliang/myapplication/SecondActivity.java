package com.leaderliang.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author liangyanqiao
 */
public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("SecondActivity", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SecondActivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SecondActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SecondActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }

}
