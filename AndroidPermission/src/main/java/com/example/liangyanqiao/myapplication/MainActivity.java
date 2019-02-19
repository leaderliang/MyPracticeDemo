package com.example.liangyanqiao.myapplication;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.*;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * api 23 以上权限处理
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PermissionHelper mPermissionHelper;

    private String TAG = "MainActivity";

    private static final int REQUEST_CODE = 1;

    private static final int REQUEST_CODE_WRITE_SETTINGS = 2;

    HandlerThread mHandlerThread;


    final Handler handler = new Handler(mHandlerThread.getLooper()){
        @Override
        public void handleMessage(Message msg) {
            System.out.println("收到消息");

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

//        android.permission.WRITE_CONTACTS
//        android.permission.CALL_PHONE
//        android.permission.READ_CALENDAR
//        android.permission.CAMERA
//        android.permission.BODY_SENSORS
//        android.permission.ACCESS_FINE_LOCATION
//        android.permission.READ_EXTERNAL_STORAGE
//        android.permission.RECORD_AUDIO
//        android.permission.READ_SMS

    public void WRITE_CONTACTS(View v) {
        requestPermission(Manifest.permission.WRITE_CONTACTS);
    }

    public void CALL_PHONE(View v) {
        requestPermission(Manifest.permission.CALL_PHONE);
    }

    public void READ_CALENDAR(View v) {
        requestPermission(Manifest.permission.READ_CALENDAR);
    }

    public void CAMERA(View v) {
        requestPermission(Manifest.permission.CAMERA);
    }

    public void BODY_SENSORS(View v) {
        requestPermission(Manifest.permission.BODY_SENSORS);
    }

    public void ACCESS_FINE_LOCATION(View v) {
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public void READ_EXTERNAL_STORAGE(View v) {
        requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    public void RECORD_AUDIO(View v) {
        requestPermission(Manifest.permission.RECORD_AUDIO);
    }

    public void READ_SMS(View v) {
        requestPermission(Manifest.permission.READ_SMS);
    }

    public void WRITE_EXTERNAL_STORAGE_AND_ACCESS_FINE_LOCATION(View v) {
        requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public void SYSTEM_ALERT_WINDOW(View v) {
        requestAlertWindowPermission();
    }

    public void WRITE_SETTINGS(View v) {
        requestWriteSettings();
    }


    private void requestPermission(String... permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 可以设置多个危险权限，用逗号隔开
            if (PermissionHelper.hasPermissions(this, permission)) {
                if(permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "已经获取过该权限啦", Toast.LENGTH_SHORT).show();
                    //执行读取操作
                    startGetImageThread();
                }
            }
            mPermissionHelper = new PermissionHelper(this);
            mPermissionHelper.requestPermissions("App 需要访问您的读取权限，请允许",
                    new PermissionHelper.PermissionListener() {
                        @Override
                        public void doAfterGrant(String... permission) {
                            Toast.makeText(MainActivity.this, "获取到该权限啦 permission=" + permission, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void doAfterDenied(String... permission) {
                            Toast.makeText(MainActivity.this, "您已拒绝使用该权限对应的功能 permission=" + permission, Toast.LENGTH_SHORT).show();
                        }
                    }, permission);// 上面设置几个权限，这里也要设置对应的权限
        }
    }

    @Override
    public void onClick(View v) {
        // 系统默认权限处理方式
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
//                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                            PermissionHelper.REQUEST_PERMISSION_CODE);
//                    return;
//                }
//            }


    }

    private void startGetImageThread() {

        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        //获取jpeg和png格式的文件，并且按照时间进行倒序
        Cursor cursor = contentResolver.query(uri, null, MediaStore.Images.Media.MIME_TYPE + "=\"image/jpeg\" or " +
                MediaStore.Images.Media.MIME_TYPE + "=\"image/png\"", null, MediaStore.Images.Media.DATE_MODIFIED + " desc");

        Toast.makeText(this, "cursor" + cursor.getColumnName(1), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mPermissionHelper.handleRequestPermissionsResult(requestCode, permissions, grantResults);

    }


    private void requestAlertWindowPermission() {
        /* Android 悬浮窗权限各机型各系统适配大全
         * http://blog.csdn.net/self_study/article/details/52859790
         */
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void requestWriteSettings() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE_WRITE_SETTINGS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                /*
                * 使用Action Settings.ACTION_MANAGE_OVERLAY_PERMISSION 启动隐式Intent
                * 使用 “package:” + getPackageName() 携带App的包名信息
                * 使用 Settings.canDrawOverlays 方法判断授权结果
                * */
                if (Settings.canDrawOverlays(this)) {
                    Log.e(TAG, "Settings  onActivityResult granted");
                }
            }
        }
        if (requestCode == REQUEST_CODE_WRITE_SETTINGS) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                /*
                * 使用Action Settings.ACTION_MANAGE_WRITE_SETTINGS 启动隐式Intent
                * 使用 “package:” + getPackageName() 携带App的包名信息
                * 使用 Settings.System.canWrite 方法检测授权结果
                * */
                if (Settings.System.canWrite(this)) {
                    Log.e(TAG, "onActivityResult write settings granted");
                }
            }
        }
    }
}
