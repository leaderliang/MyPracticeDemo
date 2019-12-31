package com.leaderliang.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leaderliang.myapplication.view.MyRelativeLayout;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/30 20:10
 */
public class ViewTouchEventActivity extends AppCompatActivity {

    private TextView mTv;
    private Button mBt;
    private MyRelativeLayout mRl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        mRl = findViewById(R.id.rl_layout);
        mTv = findViewById(R.id.text_view);
        mBt = findViewById(R.id.bt_view);

        setOnTouch();
    }

    /**
     * ViewGroup 中两个重叠的 view，当手指触摸 mTv，然后滑动，然后滑动到 mBt 上，这个过程经历的触摸变化；
     *
     * ACTION_CANCEL 事件触发的时机，当 mRl 开始拦截 这个事件的时候， cancel 会执行
     */
    private void setOnTouch() {

        mTv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("-- mTv ACTION_DOWN --");
                        // 告诉父容器，不允许拦截事件
                        mRl.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("-- mTv ACTION_UP --");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 告诉父容器，可以拦截事件
                        mRl.requestDisallowInterceptTouchEvent(false);
                        System.out.println("-- mTv ACTION_MOVE --");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        System.out.println("-- mTv ACTION_CANCEL --");
                        break;
                }
                return true;
            }
        });

        mBt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("-- mBt ACTION_DOWN --");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("-- mBt ACTION_UP --");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("-- mBt ACTION_MOVE --");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        System.out.println("-- mBt ACTION_CANCEL --");
                        break;
                }
                return true;
            }
        });
    }


}
