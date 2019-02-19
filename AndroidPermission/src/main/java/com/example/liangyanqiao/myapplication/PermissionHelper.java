package com.example.liangyanqiao.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import java.util.Arrays;
import java.util.List;

/**
 * @author leaderliang
 * @time 2017-6-26
 * <p>
 * notice:
 * 很多手机对原生系统做了修改，比如小米 4 的 6.0 的 shouldShowRequestPermissionRationale
 * 就一直返回false，而且在申请权限时，如果用户选择了拒绝，则不会再弹出对话框了, 因此接口中提供了
 * void doAfterDenied(String... permission);方法，在被拒绝后提示！
 *
 * 特殊权限 (这两个特殊权限的授权，做法是使用 startActivityForResult 启动授权界面来完成)
 * SYSTEM_ALERT_WINDOW 设置悬浮窗
 * WRITE_SETTINGS 修改系统设置
 *
 *
 *
 *
 *
 *
 */

public class PermissionHelper {

    private static final int REQUEST_PERMISSION_CODE = 10;

    private Context mContext;

    private PermissionListener mListener;

    private List<String> mPermissionList;

    public PermissionHelper(@NonNull Context context) {
        checkCallingObjectSuitability(context);
        this.mContext = context;

    }


    /**
     * 权限授权申请
     *
     * @param hintMessage 要申请的权限的提示
     * @param permissions 要申请的权限
     * @param listener    申请成功之后的callback
     */
    public void requestPermissions(@NonNull CharSequence hintMessage,
                                   @Nullable PermissionListener listener,
                                   @NonNull final String... permissions) {

        if (listener != null) {
            mListener = listener;
        }

        mPermissionList = Arrays.asList(permissions);

        //没全部权限
        if (!hasPermissions(mContext, permissions)) {

            //需要向用户解释为什么申请这个权限
            boolean shouldShowRationale = false;
            for (String perm : permissions) {
                shouldShowRationale =
                        shouldShowRationale || shouldShowRequestPermissionRationale(mContext, perm);
            }

            if (shouldShowRationale) {
                showMessageOKCancel(hintMessage, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executePermissionsRequest(mContext, permissions,
                                REQUEST_PERMISSION_CODE);

                    }
                });
            } else {
                executePermissionsRequest(mContext, permissions,
                        REQUEST_PERMISSION_CODE);
            }
        } else if (mListener != null) { //有全部权限
            mListener.doAfterGrant(permissions);
        }
    }

    /**
     * 处理onRequestPermissionsResult
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public void handleRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:
                boolean allGranted = true;
                for (int grant : grantResults) {
                    if (grant != PackageManager.PERMISSION_GRANTED) {
                        allGranted = false;
                        break;
                    }
                }

                if (allGranted && mListener != null) {

                    mListener.doAfterGrant((String[]) mPermissionList.toArray());

                } else if (!allGranted && mListener != null) {
                    mListener.doAfterDenied((String[]) mPermissionList.toArray());
                }
        }
    }

    /**
     * 判断是否具有某权限
     *
     * @param context
     * @param perms
     * @return
     */
    public static boolean hasPermissions(@NonNull Context context, @NonNull String... perms) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        for (String perm : perms) {
            boolean hasPerm = (ContextCompat.checkSelfPermission(context, perm) ==
                    PackageManager.PERMISSION_GRANTED);
            if (!hasPerm) {
                return false;
            }
        }

        return true;
    }


    /**
     * 兼容fragment
     *
     * @param object
     * @param perm
     * @return
     */
    @TargetApi(23)
    private static boolean shouldShowRequestPermissionRationale(@NonNull Object object, @NonNull String perm) {
        if (object instanceof Activity) {
            return ActivityCompat.shouldShowRequestPermissionRationale((Activity) object, perm);
        } else if (object instanceof Fragment) {
            return ((Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else if (object instanceof android.app.Fragment) {
            return ((android.app.Fragment) object).shouldShowRequestPermissionRationale(perm);
        } else {
            return false;
        }
    }

    /**
     * 执行申请,兼容fragment
     *
     * @param object
     * @param perms
     * @param requestCode
     */
    @TargetApi(23)
    private static void executePermissionsRequest(@NonNull Object object, @NonNull String[] perms, int requestCode) {
        if (object instanceof android.app.Activity) {
            ActivityCompat.requestPermissions((Activity) object, perms, requestCode);
        } else if (object instanceof android.support.v4.app.Fragment) {
            ((android.support.v4.app.Fragment) object).requestPermissions(perms, requestCode);
        } else if (object instanceof android.app.Fragment) {
            ((android.app.Fragment) object).requestPermissions(perms, requestCode);
        }
    }

    /**
     * 检查传递Context是否合法
     *
     * @param object
     */
    private static void checkCallingObjectSuitability(@Nullable Object object) {
        if (object == null) {
            throw new NullPointerException("Activity or Fragment should not be null");
        }

        boolean isActivity = object instanceof android.app.Activity;
        boolean isSupportFragment = object instanceof android.support.v4.app.Fragment;
        boolean isAppFragment = object instanceof android.app.Fragment;
        if (!(isSupportFragment || isActivity || (isAppFragment && isNeedRequest()))) {
            if (isAppFragment) {
                throw new IllegalArgumentException(
                        "Target SDK needs to be greater than 23 if caller is android.app.Fragment");
            } else {
                throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
            }
        }
    }

    public static boolean isNeedRequest() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    private void showMessageOKCancel(CharSequence message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(mContext)
                .setMessage(message)
                .setPositiveButton("ok", okListener)
                .setNegativeButton("cancel", null)
                .create()
                .show();
    }

    public interface PermissionListener {

        void doAfterGrant(String... permission);

        void doAfterDenied(String... permission);
    }
}