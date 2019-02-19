package com.android.zxing.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

/**
 * @version: V1.0
 */
public class CustomDialog extends Dialog {

	/** 布局文件 **/
	int layoutRes;
	/** 上下文对象 **/
	Context context;
	/** 确定按钮 **/
	private Button confirmBtn;
	/** 取消按钮 **/
	private Button cancelBtn;

	public CustomDialog(Context context) {
		super(context);
		this.context = context;
	}

	/**
	 * 自定义布局的构造方法
	 * 
	 * @param context
	 * @param resLayout
	 */
	public CustomDialog(Context context, int resLayout) {
		super(context);
		this.context = context;
		this.layoutRes = resLayout;
	}

	/**
	 * 自定义主题及布局的构造方法
	 * 
	 * @param context
	 * @param theme
	 * @param resLayout
	 */
	public CustomDialog(Context context, int theme, int resLayout) {
		super(context, theme);
		this.context = context;
		this.layoutRes = resLayout;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		// 指定布局
//		this.setContentView(layoutRes);
//
//		// 根据id在布局中找到控件对象
//		confirmBtn = (Button) findViewById(R.id.confirm_btn);
//		cancelBtn = (Button) findViewById(R.id.cancel_btn);
//
//		// 设置按钮的文本颜色
//		confirmBtn.setTextColor(context.getResources().getColor(R.color.skin_text1));
//		cancelBtn.setTextColor(context.getResources().getColor(R.color.skin_text1));
//
//		// 为按钮绑定点击事件监听器
//		confirmBtn.setOnClickListener(this);
//		cancelBtn.setOnClickListener(this);
	}
}