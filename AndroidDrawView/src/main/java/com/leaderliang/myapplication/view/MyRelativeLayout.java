package com.leaderliang.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/31 16:29
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            System.out.println("-- MyRelativeLayout ACTION_DOWN -- ");
            return false;
        } else {
            if (action == MotionEvent.ACTION_MOVE) {
                System.out.println("-- MyRelativeLayout ACTION_MOVE -- ");
            } else if (action == MotionEvent.ACTION_UP) {
                System.out.println("-- MyRelativeLayout ACTION_UP -- ");
            }
            return true;
        }
    }


}
