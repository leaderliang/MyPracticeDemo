package com.java.designmodel;

import java.util.concurrent.*;

/**
 * @author liangyanqiao
 */
public class test {

//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("demo-pool-%d").build();
//        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
//        singleThreadPool.shutdown();


    public static void main(String[] args) {
        /*线程池*/
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            singleThreadExecutor.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    ThreadTest mThreadTest = new ThreadTest();
//                    mThreadTest.initData();
//                }
//            });
//        }


//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.schedule(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);

        /*string*/
//        String s1 = "HelloWorld";
//        String s2 = "Hello"+ new String("World");
//        String s3 = "HelloWorld";
//        System.out.println(s1==s2);
//        System.out.println(s1==s3);
//        System.out.println(s2==s3);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));

//        for (int i = 0; i < 1_00; i++) {
//            System.out.println(i+"");
//        }

        // 向上取整
//        System.out.println(Math.ceil(0.53d));
        // 向下取整
//        System.out.println(Math.floor(0.53d));

//        for (int i = 0; i <=  19; i++) {
//            System.out.println(Math.random() * 19 + 1);
//        }


    }






}
