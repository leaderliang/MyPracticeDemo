package com.java.designmodel;

/**
 * @author liangyanqiao
 */
public class Singleton {

    /**
     * 双重校验锁模式
     */
    private volatile static Singleton mSingleton;

    public static Singleton getInstance() {
        if (mSingleton == null) {
            synchronized (Singleton.class) {
                if (mSingleton == null) {
                    mSingleton = new Singleton();
                }
            }
        }
        return mSingleton;
    }


}
