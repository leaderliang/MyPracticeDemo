package com.leaderliang.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 对阵线
 *
 * @author liang
 */
public class ViewLine extends View {

    private Paint mLinePaintLeft;
    private Paint mLinePaintRight;

    private int screenWidth;

    public ViewLine(Context context) {
        super(context,null);
    }

    public ViewLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLinePaintLeft = new Paint();
        mLinePaintLeft.setColor(Color.LTGRAY);


        mLinePaintRight = new Paint();
        mLinePaintRight.setColor(Color.DKGRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        screenWidth = getWidth();
        System.out.println("screenWidth-----"+ screenWidth);
        mLinePaintLeft.setStyle(Paint.Style.FILL);
        mLinePaintLeft.setAntiAlias(true);
        mLinePaintLeft.setStrokeWidth((float) 5.0);

        mLinePaintRight.setStyle(Paint.Style.FILL);
        mLinePaintRight.setAntiAlias(true);
        mLinePaintRight.setStrokeWidth((float) 5.0);
        /*画布背景色*/
//        canvas.drawColor(Color.GREEN);


        /*left 竖线*/
        canvas.drawLine(50, 50, 50, 100, mLinePaintLeft);

        /*中间 left 部分 横线   参数 startY 用上一步 stopY*/
        canvas.drawLine(50, 100, 150, 100, mLinePaintLeft);

        /*中间 right 部分 横线    */
        canvas.drawLine(150, 100, 250, 100, mLinePaintRight);

        /*right 竖线*/
        canvas.drawLine(250, 100, 250, 50, mLinePaintRight);

        /*下竖线*/
        canvas.drawLine(150, 100, 150, 150, mLinePaintRight);






//        /*left 竖线*/
//        canvas.drawLine(50, 50, 50, 100, mLinePaintLeft);
//
//        /*中间 left 部分 横线   参数 startY 用上一步 stopY*/
//        canvas.drawLine(50, 100, 500, 100, mLinePaintLeft);
//
//        /*中间 right 部分 横线    */
//        canvas.drawLine(500, 100, 1000, 100, mLinePaintRight);
//
//        /*right 竖线*/
//        canvas.drawLine(1000, 100, 1000, 50, mLinePaintRight);
//
//        /*下竖线*/
//        canvas.drawLine(500, 100, 500, 150, mLinePaintRight);
    }

//    public void reDrawLine(int lineNum,float startY,float viewWidth){
//        int screenWidth = getWidth();
//        int viewWidth;
//        float startX;
//        if(lineNum == 1){
//            int itemWidth = screenWidth / 4;
//            viewWidth = width - (margin * 2);
//            viewWidth / 4;
//        }
//
//        invalidate();
//    }

    public void setLeftLineLight(){

    }

    public void setRightLineLight(){

    }

    public void showTopLine(){

//        reDrawLine();
    }

    public void showBottomLine(){

//        reDrawLine();

    }













}
