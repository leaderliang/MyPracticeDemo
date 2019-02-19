package com.leaderliang.myvideocompress;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liang
 *
 * String cmd = "-y -i " + currentInputVideoPath + " -strict -2 -vcodec libx264 -preset ultrafast " +
 * "-crf 24 -acodec aac -ar 44100 -ac 2 -b:a 96k -s 320x480 -aspect 16:9 " + currentOutputVideoPath;
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mInputVideoPath;
    private EditText mInputCompressOrder;
    private TextView mTvShowCompressLog;
    private ScrollView mScrollView;
    private Compressor mCompressor;

    private String currentInputVideoPath = "/mnt/sdcard/blue.mp4";
    private String currentOutputVideoPath = "/mnt/sdcard/red.mp4";
    String cmd = "-y -i " + currentInputVideoPath + " -strict -2 -vcodec libx264 -preset ultrafast " +
            "-crf 24 -acodec aac -ar 44100 -ac 2 -b:a 96k -s 320x480 " + currentOutputVideoPath;

//    String cmd = "-i " + currentInputVideoPath + " -vcodec h264 -preset fast -crf 28 -y -acodec libmp3lame -ab 128k " + currentOutputVideoPath;

//    String cmd = " -i %@ -vcodec mpeg4 -b:v 1500K -y %@ " + currentInputVideoPath + " "+ currentOutputVideoPath;
    private static final Handler handler = new Handler();
    /**
     * 视频时长 s
     */
    private Double videoLength = 14.898;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mCompressor = new Compressor(this);
        mCompressor.loadBinary(new InitListener() {
            @Override
            public void onLoadSuccess() {
                Log.v(TAG, "load library succeed");
                textAppend(getString(R.string.compress_load_library_succeed));
            }

            @Override
            public void onLoadFail(String reason) {
                Log.i(TAG, "load library fail:" + reason);
                textAppend(getString(R.string.compress_load_library_failed, reason));
            }
        });
    }


    private void initView() {
        mInputVideoPath = (EditText) findViewById(R.id.input_video_path);
        mInputCompressOrder = (EditText) findViewById(R.id.input_compress_order);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mTvShowCompressLog = (TextView) findViewById(R.id.tv_show_compress_log);

        mInputVideoPath.setText(currentInputVideoPath);
        mInputCompressOrder.setText(cmd);
    }


    public void runCompressOrder(View view) {
        currentInputVideoPath = mInputVideoPath.getText().toString().trim();
        String command = mInputCompressOrder.getText().toString();
        if (TextUtils.isEmpty(currentInputVideoPath)) {
            Toast.makeText(this, "请输入要压缩的视频路径", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(command)) {
            Toast.makeText(this, "请输入命令", Toast.LENGTH_SHORT).show();
            return;
        } else {
            File file = new File(currentOutputVideoPath);
            if (file.exists()) {
                file.delete();
            }
            execCommand(command);
        }

    }

    public void stopCompressOrder(View view){
        mCompressor.ffmpeg.killRunningProcesses();

    }


    public void getCompressOrderState(View view){
        Toast.makeText(this, "命令执行状态"+ mCompressor.ffmpeg.isFFmpegCommandRunning(), Toast.LENGTH_SHORT).show();
    }




    private void execCommand(String cmd) {
        File mFile = new File(currentOutputVideoPath);
        if (mFile.exists()) {
            mFile.delete();
        }
        mCompressor.execCommand(cmd, new CompressListener() {
            @Override
            public void onExecSuccess(String message) {
                Log.i(TAG, "success-----> " + message);
                textAppend("压缩成功");
                Toast.makeText(getApplicationContext(), "压缩成功", Toast.LENGTH_SHORT).show();
                String result = getString(R.string.compress_result_input_output, currentInputVideoPath
                        , getFileSize(currentInputVideoPath), currentOutputVideoPath, getFileSize(currentOutputVideoPath));
                textAppend(result);
            }

            @Override
            public void onExecFail(String reason) {
                Log.i(TAG, "fail-----> " + reason);
                textAppend(getString(R.string.compress_failed, reason));

            }

            @Override
            public void onExecProgress(String message) {
                Log.i(TAG, "progress-----> " + message);
                textAppend(getString(R.string.compress_progress, message));
                Log.v(TAG, getString(R.string.compress_progress, getProgress(message)));


            }
        });
    }

    private String getFileSize(String path) {
        File f = new File(path);
        if (!f.exists()) {
            return "0 MB";
        } else {
            long size = f.length();
            return (size / 1024f) / 1024f + "MB";
        }
    }


    private void textAppend(String text) {
        if (!TextUtils.isEmpty(text)) {
            mTvShowCompressLog.append(text + "\n");
            handler.post(new Runnable() {
                @Override
                public void run() {
                    mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }
    }

    private String getProgress(String source) {
        //progress frame=   28 fps=0.0 q=24.0 size= 107kB time=00:00:00.91 bitrate= 956.4kbits/s
        Pattern p = Pattern.compile("00:\\d{2}:\\d{2}");
        Matcher m = p.matcher(source);
        if (m.find()) {
            //00:00:00
            String result = m.group(0);
            String temp[] = result.split(":");
            Double seconds = Double.parseDouble(temp[1]) * 60 + Double.parseDouble(temp[2]);
            Log.v(TAG, "current second = " + seconds);
            if (0 != videoLength) {
                return seconds / videoLength+"";
            }
            return "0";
        }
        return "";
    }

}
