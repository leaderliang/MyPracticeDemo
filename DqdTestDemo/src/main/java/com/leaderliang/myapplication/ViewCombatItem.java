package com.leaderliang.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 对阵 view item
 * @author liangyanqiao
 */
public class ViewCombatItem extends LinearLayout {


    private LinearLayout mLlLine;
    private TextView mScoreText;

    public ViewCombatItem(Context context) {
        super(context, null);
    }

    public ViewCombatItem(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ViewCombatItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        mLlLine = (LinearLayout) findViewById(R.id.ll_line);
//        mScoreText = (TextView) findViewById(R.id.tv_score);

    }

    public void setmScoreText(int id) {
        mScoreText.setText(id);
    }

    public void setmScoreText(String text) {
        mScoreText.setText(text);
    }

    public void setLineBg(int id){
        mLlLine.setBackgroundColor(id);
    }





}
