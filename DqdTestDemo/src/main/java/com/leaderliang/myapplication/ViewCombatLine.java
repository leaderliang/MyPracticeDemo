package com.leaderliang.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 对阵 view 线
 *
 * @author liangyanqiao
 */
public class ViewCombatLine extends RelativeLayout {


    private ImageView mFlagImageLeft;
    private TextView mFlagTextLeft;
    private ImageView mFlagImageRight;
    private TextView mFlagTextRight;
    private LinearLayout ll_left,ll_right;
    private Paint mLinePaintLeft;

    public ViewCombatLine(Context context) {
        super(context,null);
    }

    public ViewCombatLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    private void initView(Context context) {

//        LinearLayout.LayoutParams pas = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        pas.gravity =  Gravity.CENTER;
//        TextView tv_left = new TextView(context);
//        ImageView iv_left = new ImageView(context);
//        LinearLayout l_left = new LinearLayout(context);
//        tv_left.setTextSize(10);
//        l_left.setOrientation(LinearLayout.VERTICAL);
//        l_left.addView(iv_left,pas);
//        l_left.addView(tv_left,pas);
//        LinearLayout.LayoutParams iv_params_left = (LinearLayout.LayoutParams) iv_left.getLayoutParams();
//        iv_params_left.weight = 60;
//        iv_params_left.height = 60;
//        iv_left.setLayoutParams(iv_params_left);
//        iv_left.setImageResource(R.drawable.ic_launcher);
//
//
//        LinearLayout l_right = new LinearLayout(context);
//        ImageView iv_right = new ImageView(context);
//        TextView tv_right = new TextView(context);
//        tv_right.setTextSize(10);
//        l_right.setOrientation(LinearLayout.VERTICAL);
//        l_right.addView(iv_right,pas);
//        l_right.addView(tv_right,pas);
//        iv_right.setImageResource(R.drawable.ic_launcher);
//        LinearLayout.LayoutParams iv_params_right = (LinearLayout.LayoutParams) iv_right.getLayoutParams();
//        iv_params_right.weight = 60;
//        iv_params_right.height = 60;
//        iv_right.setLayoutParams(iv_params_right);
//
//        addView(l_left);
//        addView(l_right);
//
//        RelativeLayout.LayoutParams layoutParams_Left = (LayoutParams) l_left.getLayoutParams();
//        layoutParams_Left.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//
//        l_left.setLayoutParams(layoutParams_Left);
//        tv_left.setText("1");
//
//        RelativeLayout.LayoutParams layoutParams_Right = (LayoutParams) l_right.getLayoutParams();
//        layoutParams_Right.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//
//        l_right.setLayoutParams(layoutParams_Right);
//        tv_right.setText("2");


        LayoutInflater mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.view_item_first, this, true);

        ll_left = (LinearLayout)findViewById(R.id.ll_left);
        mFlagImageLeft = (ImageView) findViewById(R.id.iv_flag_icon_left);
        mFlagTextLeft = (TextView) findViewById(R.id.tv_flag_left);

        ll_right = (LinearLayout)findViewById(R.id.ll_right);
        mFlagImageRight = (ImageView) findViewById(R.id.iv_flag_icon_right);
        mFlagTextRight = (TextView) findViewById(R.id.tv_flag_right);

        ViewLine mViewLine = new ViewLine(context,null);
        addView(mViewLine);

        mLinePaintLeft = new Paint();
        mLinePaintLeft.setColor(Color.LTGRAY);

    }


    @Override
    protected void onDraw(Canvas canvas) {
         int screenWidth = getWidth();
        mLinePaintLeft.setStyle(Paint.Style.FILL);
        mLinePaintLeft.setAntiAlias(true);
        mLinePaintLeft.setStrokeWidth((float) 5.0);

         int itemViewWidth = screenWidth / 4;
        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(itemViewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll_left.setLayoutParams(paramsLeft);
        ll_left.getX();

    }




}
