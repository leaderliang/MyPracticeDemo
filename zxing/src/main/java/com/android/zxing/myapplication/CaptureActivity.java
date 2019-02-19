package com.android.zxing.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码扫一扫
 * 
 * @author leaderliang
 */
public final class CaptureActivity extends AppCompatActivity implements
        QRCodeReaderView.OnQRCodeReadListener {

    private static final String TAG = CaptureActivity.class.getSimpleName();

    private static final long VIBRATE_DURATION = 200L;

    private QRCodeReaderView mydecoderview;

    private ImageView scanLine;

    private ImageView mFlash;

    private CustomDialog errorDialog;

    @Override
    public void onCreate(Bundle data) {
        super.onCreate(data);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_qr_scan);
        initView();

    }

    @Override
    public void onQRCodeRead(final String text) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(VIBRATE_DURATION);
                Toast.makeText(CaptureActivity.this, "扫描结果: " + text, Toast.LENGTH_SHORT).show();
                mydecoderview.getCameraManager().stopPreview();
            }
        });

    }

    // Called when your device have no camera
    @Override
    public void cameraNotFound() {
        Log.e(TAG, "相机打开出错");
        displayFrameworkBugMessageAndExit();
    }

    // Called when there's no QR codes in the camera preview image
    @Override
    public void QRCodeNotFoundOnCamImage() {
    }

    @Override
    public void openCameraError() {
        Log.e(TAG, "无法获取摄像头数据,请检查是否已经打开摄像头权限");
        Toast.makeText(this, "无法获取摄像头数据,请检查是否已经打开摄像头权限 ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mydecoderview.getCameraManager().startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mydecoderview.getCameraManager().stopPreview();
    }

    private void initView() {

        mydecoderview = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        mydecoderview.setOnQRCodeReadListener(this);
        scanLine = (ImageView) findViewById(R.id.capture_scan_line);

        mFlash = (ImageView) findViewById(R.id.capture_flash);


        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.95f);
        animation.setDuration(2500);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        scanLine.startAnimation(animation);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    public void onConfirm() {
//        super.onConfirm();
//        try {
//            mydecoderview.getCameraManager().getCamera().setPreviewCallback(this.mydecoderview);
//            mydecoderview.getCameraManager().startPreview();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onCancel() {
//        super.onCancel();
//        mydecoderview.getCameraManager().getCamera().setPreviewCallback(this.mydecoderview);
//        mydecoderview.getCameraManager().startPreview();
//    }


    private void displayFrameworkBugMessageAndExit() {
        // camera error
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("相机打开出错，请稍后重试");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }

        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        builder.show();
    }

    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //wjyteacher://check_in_with_user_id?user_id=%@&user_name=%@&user_type=%@&user_cardnumber=%@
    private Map<String, String> splitCheckinParams(String str) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        String[] str1 = str.split("\\?");
//        String[] host = str1[0].split("\\:");
        if (str1.length > 1) {
            String[] params = str1[1].split("\\&");
            for (String parmCp : params) {
                String[] subParams = parmCp.split("\\=");
                if (subParams.length > 1) {
                    paramsMap.put(subParams[0], subParams[1]);
                }
            }
        }
        return paramsMap;
    }

}