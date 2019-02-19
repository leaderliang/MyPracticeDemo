package com.leaderliang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * 事件拦截
 */
public class MainActivity extends AppCompatActivity {

    private Button bt_1;
    private MyRelativeLayout rl_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_1 = (MyRelativeLayout) findViewById(R.id.rl_1);
        bt_1 = (Button) findViewById(R.id.bt_1);
        rl_1.setClickable(true);



        rl_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("rl_1 run onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("rl_1 run onTouch ACTION_UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("rl_1 run onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        System.out.println("rl_1 run onTouch ACTION_CANCEL");
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        System.out.println("rl_1 run onTouch ACTION_OUTSIDE");
                        break;
                }

                return false;
            }
        });
        rl_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("rl_1 run onClick");
            }
        });
        bt_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("run onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("run onTouch ACTION_UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("run onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        System.out.println("run onTouch ACTION_CANCEL");
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        System.out.println("run onTouch ACTION_OUTSIDE");
                        break;
                }

                return false;
            }
        });

        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("run onClick");
            }
        });
    }






}
