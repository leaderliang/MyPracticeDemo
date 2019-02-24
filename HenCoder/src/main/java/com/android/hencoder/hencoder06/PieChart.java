package com.android.hencoder.hencoder06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义饼图饼图
 * @author liangyanqiao
 */
public class PieChart extends View {

    private static final float RADIUS = Utils.dp2px(150);
    private final float[] ANGLE = {60f, 80f, 120f, 100f};
    private final String[] COLORS = {"#DC143C", "#2E8B57", "#0000FF", "#FFD700"};
    private final float LENGTH = Utils.dp2px(20f);
    private int index = 1;

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF mRectF = new RectF();


    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentAngle = 0;
        for (int i = 0; i < COLORS.length; i++) {
            mPaint.setColor(Color.parseColor(COLORS[i]));

            canvas.save();
            if(i == index){
                canvas.translate((float) Math.cos(Math.toRadians(currentAngle + ANGLE[i] / 2)) * LENGTH,
                        (float) Math.sin(Math.toRadians(currentAngle + ANGLE[i] / 2)) * LENGTH);
            }
            canvas.drawArc(mRectF, currentAngle, ANGLE[i], true, mPaint);
            // restore 会恢复到 save 之前的操作
            canvas.restore();

            currentAngle += ANGLE[i];
        }


    }
}