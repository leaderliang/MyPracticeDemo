package com.example.liangyanqiao.myapplication;

import android.provider.Settings;

/**
 * TODO
 * Created by liangyanqiao on 2018/3/20.
 */
public class SingletonTest {

    private static SingletonTest instance;

    private SingletonTest() {

    }

    public static synchronized SingletonTest getInstance() {
        if (instance == null) {
            instance = new SingletonTest();
            System.out.println("Singleton  Test print");
        }
        return instance;
    }
}
