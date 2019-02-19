package com.leaderliang.myapplication.view;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Paint And Canvas 简单实用
 *
 * @author liangyanqiao
 */
public class PaintAndCanvas extends View {


    private Path mPath;
    private Paint mPaint;

    public PaintAndCanvas(Context context) {
        super(context);
    }

    public PaintAndCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
//        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2f);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
//        mPaint.setTextSize(12f);

        mPath = new Path();


    }

    public PaintAndCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(300, 300, 100, mPaint);

//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawRect(100, 100, 500, 500, mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(700, 100, 1100, 500, mPaint);

        /* 点  三种 ROUND 圆头，BUTT 平头，SQUARE 方头*/
//        mPaint.setStrokeCap(Paint.Cap.BUTT);
//        canvas.drawPoint(100,100,mPaint);


        /*多个点*/
//        float[] pts = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50};
//        canvas.drawPoints(pts, /*表示跳过两个数，即前两个数字 0*/, /*一共绘制八个数（4个点）*/ , mPaint);
//        canvas.drawPoints(pts, 2, 8, mPaint);

        /*椭圆  绘制横着或者竖着的椭圆  drawOval 也可以画圆*/
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawOval(50, 50, 350, 200, mPaint);
//        canvas.drawOval(350, 350, 450, 450, mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        RectF oval = new RectF(400f, 50f, 500, 300f);
//        canvas.drawOval(oval, mPaint);

        /*画线  参数分别是线的起点和终点坐标*/
//        canvas.drawLine(200, 200, 800, 500, mPaint);

//        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120,120};
//        canvas.drawLines(points, mPaint);


        /*画圆角矩形 同样支持 style*/
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawRoundRect(100, 100, 500, 300, 50, 50, mPaint);


        /*drawArc() 是使用一个椭圆来描述弧形的。left、top、right、bottom、描述的是这个弧形所在的椭圆；
        startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）；
        sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。*/
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawArc(200, 100, 800, 500, -110, 100, true, mPaint);
//        canvas.drawArc(200, 100, 800, 500, 20, 140, false, mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(200, 100, 800, 500, 180, 60, false, mPaint);



        /*path*/


        /*路径方向，cw 顺时针； ccw 逆时针*/
//        mPath.addCircle(300f, 300f, 200f, Path.Direction.CCW);
//        canvas.drawPath(mPath, mPaint);

        /*绝对坐标；从 当前位置向目标位置画一条直线，x y 是目标位置的坐标。*/
//        mPath.lineTo(100,100);
        /*相对坐标； 相对 当前位置 的相对坐标*/
//        mPath.rLineTo(100, 0);
        /*当前位置： 即最后一次调用画 path 方法的终点位置。初始值为原点 （0，0））*/
//        canvas.drawPath(mPath, mPaint);

        /*二次贝塞尔曲线*/
//        mPath.quadTo();
//        mPath.rQuadTo();

        /*三次贝塞尔曲线*/
//        mPath.cubicTo();
//        mPath.rCubicTo();

        /*画弧形*/
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.lineTo(100, 100);
        /* forceMoveTo 绘制是要【true 抬一下笔移动过去】 还是 【false 直接拖着笔过去】  区别在于是否留下移动的痕迹*/
//        mPath.arcTo(100, 100, 300, 300, -90, 90, false);

//        mPath.addCircle(300, 300, 200, Path.Direction.CCW);
//        canvas.drawPath(mPath, mPaint);


        /*close 由当前位置向子视图的起点绘制一条直线*/
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.moveTo(100, 100);
//        mPath.lineTo(200, 100);
//        mPath.lineTo(150, 150);
//        //mPath.setFillType(Path.FillType.WINDING);
        /* 使用 close（） 封闭 子图形，等价于 path.lineTo(100, 100) */
//        mPath.close();
//        canvas.drawPath(mPath, mPaint);



    }


}
