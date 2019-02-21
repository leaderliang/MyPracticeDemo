package com.android.hencoder.hencoder06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.nio.file.spi.FileTypeDetector;

public class PathViewPractice extends View {

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    // or use setAntiAlias(true/false)
    //mPaint.setAntiAlias(true);
    Path mPath = new Path();


    public PathViewPractice(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Path.Direction.CCW 逆时针    Path.Direction.CW 顺时针
        mPath.reset();
        mPath.addRect(getWidth() / 2 - 150, getHeight() / 2 - 300, getWidth() / 2 + 150,
                getHeight() / 2, Path.Direction.CCW);

        mPath.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CW);
//        mPath.addCircle(getWidth() / 2, getHeight() / 2, 370, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Path.FillType.WINDING  从区域里向外画线，与线相交的交点，判断线是从左还是右穿过的，方向。
        // 多个交点都是同一个方向的话就相加，否则 就要抵消。如 左右 相交的点数就还是 0；
        // 总数不是 0 的话，就可以判断是在 内部。
        // 如果是  0 的话，就判断是在 外部。
        mPath.setFillType(Path.FillType.WINDING);
        // Path.FillType.EVEN_ODD  EVEN_ODD 不考虑 path 的方向
        // 从区域里向外画线， 单数是内部，要填充的部分；双数的是外部，是白色的区域
//        mPath.setFillType(Path.FillType.EVEN_ODD);


//        Path.FillType.INVERSE_EVEN_ODD
//        Path.FillType.INVERSE_WINDING
        // 上面两个 加了 INVERSE 前缀的，意思 也就是和不加前缀 相反的效果了。


        canvas.drawPath(mPath, mPaint);
    }
}