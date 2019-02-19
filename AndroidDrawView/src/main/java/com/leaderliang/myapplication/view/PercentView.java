package com.leaderliang.myapplication.view;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义百分比 饼状图 view
 * 基本原理
 * @author liangyanqiao
 */
public class PercentView extends View {

    private static final String TAG = PercentView.class.getSimpleName();
    private Paint mPaint;

    public PercentView(Context context) {
        super(context);

    }

    public PercentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PercentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void init() {
        mPaint = new Paint();
        //第一个函数是用来防止边缘的锯齿
        mPaint.setAntiAlias(true);
        //第二个函数是用来对位图进行滤波处理
        mPaint.setFilterBitmap(true);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure");

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.UNSPECIFIED:

                break;
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            default:
        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightSize);


    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "onDraw");
        mPaint.setColor(Color.GRAY);
        // FILL填充, STROKE描边,FILL_AND_STROKE填充和描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        int with = getWidth();
        int height = getHeight();

        Log.e(TAG, "onDraw----->" + with + "*" + height);
        // 设置半径画圆
        float radius = with / 4;
        canvas.drawCircle(with / 2, with / 2, radius, mPaint);

        mPaint.setColor(Color.BLACK);
        //用于定义的圆弧的形状和大小的界限
        RectF oval = new RectF(with / 2 - radius, with / 2 - radius, with / 2 + radius, with / 2 + radius);
        //根据进度画圆弧,从0开始画，横扫角度120
        canvas.drawArc(oval, 0, 120, true, mPaint);
    }







}
