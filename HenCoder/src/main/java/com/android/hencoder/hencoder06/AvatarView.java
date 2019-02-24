package com.android.hencoder.hencoder06;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.android.hencoder.R;

/**
 * 获取图片，对图片进行裁剪，添加边框等
 *
 * @author liangyanqiao
 */
public class AvatarView extends View {

    private final int WIDTH = (int) Utils.dp2px(300);
    private final float padding = Utils.dp2px(50f);
    private final float PADDING_EDGE = Utils.dp2px(10f);
    private Bitmap mBitmap;
    private RectF bounds = new RectF();


    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    PorterDuffXfermode mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);


    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    {
        mBitmap = getAvatarView(WIDTH);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        bounds.set(padding, padding, padding + WIDTH, padding + WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.parseColor("#B71C1C"));
        // 图片外再加一层边框
        canvas.drawOval(padding, padding, padding + WIDTH, padding + WIDTH, mPaint);


        // 离屏缓冲
        int save = canvas.saveLayer(bounds, mPaint);

//        canvas.drawOval(padding,padding,padding+ WIDTH,padding + WIDTH, mPaint);
        // 加了边框后，坐标就要进行相应变动
        canvas.drawOval(padding + PADDING_EDGE, padding + PADDING_EDGE, padding + WIDTH - PADDING_EDGE, padding + WIDTH - PADDING_EDGE, mPaint);

        // Xfermode transfer mode 图形进行叠加处理
        mPaint.setXfermode(mPorterDuffXfermode);
        canvas.drawBitmap(mBitmap, padding, padding, mPaint);

        // 恢复
        mPaint.setXfermode(null);
        // 画完图之后进行恢复 离屏缓冲
        canvas.restoreToCount(save);
    }


    private Bitmap getAvatarView(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        // options.inJustDecodeBounds  如果将这个值置为true，那么在解码的时候将不会返回bitmap，只会返回这个bitmap的尺寸。
        // 这个属性的目的是，如果你只想知道一个bitmap的尺寸，但又不想将其加载到内存时。这是一个非常有用的属性
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.girl, options);
        // outWidth和outHeight 表示这个Bitmap的宽和高，一般和inJustDecodeBounds一起使用来获得Bitmap的宽高，但是不加载到内存
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;

        // 获取原始图片尺寸 和 图片格式
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), R.drawable.girl, options);
    }


    /**
     * 图片的显示可以选择缩略图的形式减少内存占用
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // 原始图片尺寸
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高比率中最小的作为inSampleSize的值，这样可以保证最终生成图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}