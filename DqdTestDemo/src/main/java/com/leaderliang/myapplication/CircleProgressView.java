package com.leaderliang.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO
 * Created by liangyuanyuan on 2018/5/8.
 */
public class CircleProgressView extends View {

    private int mMaxProgress = 100;

    private int mProgress = 30;

    private final int mCircleLineStrokeWidth = 8;

    private final int mTxtStrokeWidth = 2;

    /**
     * 画圆所在的距形区域
     */
    private final RectF mRectF;

    private final Paint mPaint;

    private final Context mContext;

    private String mTopText;

    private String mTxtHint2;

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        mRectF = new RectF();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();

        if (width != height) {
            int min = Math.min(width, height);
            width = min;
            height = min;
        }

        canvas.drawColor(Color.TRANSPARENT);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#ffcccc"));
        mPaint.setStrokeWidth(mCircleLineStrokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);

        mRectF.left = mCircleLineStrokeWidth / 2; // 左上角x
        mRectF.top = mCircleLineStrokeWidth / 2; // 左上角y
        mRectF.right = width - mCircleLineStrokeWidth / 2; // 左下角x
        mRectF.bottom = height - mCircleLineStrokeWidth / 2; // 右下角y

        /*绘制圆圈，进度条背景*/
        canvas.drawArc(mRectF, 120, 300, false, mPaint);
        /*绘制进度区域*/
        mPaint.setColor(Color.parseColor("#f23030"));
        canvas.drawArc(mRectF, 120, ((float) mProgress / mMaxProgress) * 300, false, mPaint);

        /*绘制进度文案显示*/
        mPaint.setStrokeWidth(mTxtStrokeWidth);
        String text = mProgress + "%";
        int textHeight = height / 4;
        mPaint.setTextSize(textHeight);
        int textWidth = (int) mPaint.measureText(text, 0, text.length());
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, width / 2 - textWidth / 2, height / 2 + textHeight, mPaint);

        if (!TextUtils.isEmpty(mTopText)) {
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            text = mTopText;
            textHeight = height / 4;
            mPaint.setTextSize(textHeight);
            mPaint.setColor(Color.parseColor("#f23030"));
            textWidth = (int) mPaint.measureText(text, 0, text.length());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(text, width / 2 - textWidth / 2, (float) (height / 4 + textHeight / 1.5), mPaint);
        }

        if (!TextUtils.isEmpty(mTxtHint2)) {
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            text = mTxtHint2;
            textHeight = height / 8;
            mPaint.setTextSize(textHeight);
            textWidth = (int) mPaint.measureText(text, 0, text.length());
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawText(text, width / 2 - textWidth / 2, 3 * height / 4 + textHeight / 2, mPaint);
        }
    }

    public int getMaxProgress() {
        return mMaxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    public void setProgress(int progress) {
        this.mProgress = progress;
        this.invalidate();
    }

    public void setProgressNotInUiThread(int progress) {
        this.mProgress = progress;
        this.postInvalidate();
    }

    public String getTopText() {
        return mTopText;
    }

    public void setTopTxt(String str) {
        this.mTopText = str;
    }

    public String getmTxtHint2() {
        return mTxtHint2;
    }

    public void setmTxtHint2(String mTxtHint2) {
        this.mTxtHint2 = mTxtHint2;
    }
}
