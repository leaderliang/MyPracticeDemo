package com.android.hencoder.hencoder06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义运动轨迹，圆形进度条
 * @author liangyanqiao
 */
public class SportsView extends View {
    private final float RADIUS = Utils.dp2px(150f);

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SportsView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制环
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(Utils.dp2px(20f));
        mPaint.setColor(Color.parseColor("#90A4AE"));

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Utils.dp2px(150f), mPaint);


        // 绘制进度条

        mPaint.setColor(Color.parseColor("#FF4081"));
        // 设置线冒样式，取值有Cap.ROUND(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒)
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS,-180,250, false, mPaint);



    }


}