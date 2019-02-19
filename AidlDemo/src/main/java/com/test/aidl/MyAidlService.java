package com.test.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import com.test.aidl.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MyAidlService extends Service {

    private final String TAG = this.getClass().getSimpleName();
    private ArrayList<Person> mPersons;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mPersons = new ArrayList<>();
        Log.d(TAG, "MyAidlService onBind");
        return mIBinder;
    }

    IBinder mIBinder = new IMyAidl.Stub(){

        @Override
        public void addPerson(Person person) throws RemoteException {
            mPersons.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return mPersons;
        }
    };


}
