package com.android.hencoder.hencoder06;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义 view 仪表盘
 *
 * @author liangyanqiao
 */
public class DashBoard extends View {
    private final float ANGLE = 120F;
    private final float RADIUS = Utils.dp2px(150F);
    private final float LENGTH = Utils.dp2px(100);
    private Paint mPaint;
    private Path mShape;
    private RectF mRectF;
    private PathEffect mEffect;

    public DashBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mShape = new Path();

        mRectF = new RectF(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(Utils.dp2px(2f));

        mShape.addRect(0, 0, Utils.dp2px(2f), Utils.dp2px(10), Path.Direction.CW);

        Path mArc = new Path();
//        mArc.addArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS, 90F + ANGLE / 2, 360 - ANGLE);
        mArc.addArc(mRectF, 90F + ANGLE / 2, 360 - ANGLE);
        PathMeasure pathMeasure = new PathMeasure(mArc, false);
        // 分 20 份，减 2f 是因为总长度不够，需要减去一条线的宽度，再等分
        float advance = (pathMeasure.getLength() - Utils.dp2px(2f)) / 20;
        mEffect = new PathDashPathEffect(mShape, advance, 0, PathDashPathEffect.Style.ROTATE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);

        /*画线*/
        canvas.drawArc(rectF, 90F + ANGLE / 2, 360 - ANGLE, false, mPaint);

        /*画刻度*/
        /**
         * 破折线
         * advance 每个形状印章之间的间距
         * phase 第一个点之前需不需要有一段距离，距离是多少
         * PathDashPathEffect.Style.ROTATE  和 PathDashPathEffect.Style.MORPH 从效果上看区别不太大
         *
         */
        mPaint.setPathEffect(mEffect);
        canvas.drawArc(rectF, 90F + ANGLE / 2, 360 - ANGLE, false, mPaint);
        mPaint.setPathEffect(null);


        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Utils.dp2px(3), mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        // 画指针
        // toRadians(double angdeg) 转换为度，以弧度为单位的近似等效角的角度。从角度到弧度的转换通常是不精确的
        canvas.drawLine(getWidth() / 2, getHeight() / 2,
                (float) Math.cos(Math.toRadians(getAngleFromMark(1))) * LENGTH + getWidth() / 2,
                (float) Math.sin(Math.toRadians(getAngleFromMark(1))) * LENGTH + getHeight() / 2,
                mPaint);


    }


    float getAngleFromMark(int mark) {
        return (360 - ANGLE) / 20 * mark + 90 + ANGLE / 2;
    }
}