package com.leaderliang.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author liangyanqiao
 */
public class ViewCountryItem extends LinearLayout {


    private ImageView mFlagImage;
    private TextView mFlagText;
    private int mFlagImageWidth = 0;
    private int mFlagTextWidth = 0;

//    public ViewCountryItem(Context context) {
//        super(context);
//    }

    public ViewCountryItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        mFlagImage = (ImageView) findViewById(R.id.iv_flag_icon);
//        mFlagText = (TextView) findViewById(R.id.tv_flag);
    }

    private void initView(Context context) {
//        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mInflater.inflate(R.layout.view_item_first, this, true);

        LayoutInflater mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.view_item_first, this,true);
        setOrientation(LinearLayout.VERTICAL);
        mFlagImage = (ImageView) findViewById(R.id.iv_flag_icon_left);
        mFlagText = (TextView)   findViewById(R.id.tv_flag_left);
    }
    public void setFlagText(int id) {
        mFlagText.setText(id);
    }

    public void setFlagText(String text) {
        mFlagText.setText(text);
    }

    public void setFlagImage(int id) {
        mFlagImage.setImageResource(id);
    }

    public int getItemViewWidth() {
        if(mFlagImageWidth != 0 && mFlagTextWidth != 0){
            if(mFlagImageWidth > mFlagTextWidth){
                return mFlagImageWidth;
            }else{
                return mFlagTextWidth;
            }
        }
        return 0;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mFlagImageWidth = mFlagImage.getMeasuredWidth();
        mFlagTextWidth = mFlagText.getMeasuredWidth();

    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
            System.out.println(" measureHeight EXACTLY result " + result);
        } else {
            //这样，当时用wrap_content时，View就获得一个默认值200px，而不是填充整个父布局。
            result = 50;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
            System.out.println("measureHeight AT_MOST result " + result);
        }

        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
            System.out.println("measureWidth EXACTLY result " + result);
        } else {
            //这样，当时用wrap_content时，View就获得一个默认值200px，而不是填充整个父布局。
            result = 180;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
            System.out.println("measureWidth AT_MOST result " + result);
        }

        return result;
    }


}
