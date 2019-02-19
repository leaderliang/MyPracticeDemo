package com.test.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.test.aidl.bean.Person;

import java.util.List;
import java.util.Random;

/**
 * @author liangyanqiao
 * 在 Activity 中创建一个服务连接对象，在其中调用 IMyAidl.Stub.asInterface() 方法将 Binder 转为 AIDL 类。
 * 绑定服务
 * 要执行 IPC，必须使用 bindService() 将应用绑定到服务上
 * <p>
 * 5.0 以后要求显式调用 Service，所以我们无法通过 action 或者 filter 的形式调用 Service
 * https://blog.csdn.net/u011240877/article/details/72654743
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTvName;

    private IMyAidl mAidl;
    private PersonConnection personConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvName = (TextView) findViewById(R.id.out_put);

        Intent intent = new Intent(this, MyAidlService.class);
//        intent.setComponent(new ComponentName("com.test.aidl","com.test.aidl.MyAidlService"));

        personConnection = new PersonConnection();
        bindService(intent, personConnection, BIND_AUTO_CREATE);


    }

    private class PersonConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理
            mAidl = IMyAidl.Stub.asInterface(service);
            Log.d("MainActivity", "------> onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("MainActivity", "------> onServiceDisconnected");
            mAidl = null;
        }
    }

    public void OnAddPerson(View view) {
        Random random = new Random();
        Person p = new Person("aidl test" + random.nextInt(10));
        try {
            mAidl.addPerson(p);
            List<Person> list = mAidl.getPersonList();

            mTvName.setText(list.toString() + " size " + list.size());

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        unbindService(personConnection);
        super.onDestroy();
    }
}
