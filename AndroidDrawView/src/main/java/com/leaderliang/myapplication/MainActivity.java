package com.leaderliang.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.leaderliang.myapplication.scrollnesting.RecycleViewAdapter;

/**
 * @author liangyanqiao
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private LinearLayoutManager mLayoutManage;
    private RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.view_paint_and_canvas);
//        setContentView(R.layout.view_scroll_nesting);
        setContentView(R.layout.view_circle);

        Log.d("MainActivity", "onCreate");


        /*recycleView = findViewById(R.id.recycler_view);
        recycleView.setHasFixedSize(true);//设置固定大小
        recycleView.setItemAnimator(new DefaultItemAnimator());//设置默认动画
        mLayoutManage = new LinearLayoutManager(this);
        mLayoutManage.setOrientation(OrientationHelper.HORIZONTAL);//设置滚动方向，横向滚动
        recycleView.setLayoutManager(mLayoutManage);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("");
        }
        adapter = new RecycleViewAdapter(this, R.layout.recycleview_bringinto, data);
        recycleView.setAdapter(adapter);*/


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState + outState = "+outState.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity", "onRestoreInstanceState + savedInstanceState = "+savedInstanceState.toString());
    }

    /**
     * 打开Dialog、Toast不会影响到Activity的生命周期
     */
    public void showDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("测试生命周期").setMessage("测试生命周期").create();
        dialog.show();
    }

    public void startActivity(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("MainActivity", "onConfigurationChanged newConfig"+ newConfig.toString());
    }
}
