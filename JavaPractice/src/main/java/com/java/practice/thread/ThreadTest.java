package com.java.practice.thread;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/20 19:33
 */
public class ThreadTest {

    static final int[] arr1 = {1, 2, 3, 5};
    static final int[] arr2 = {4, 5, 6};

    public static void main(String[] args) {

      /*  Runnable target = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread  runnable started!");
            }
        };
        Thread runnableThread = new Thread(target);
        runnableThread.start();*/


        ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest::thread1);
        Thread thread2 = new Thread(threadTest::thread2);

        thread1.start();
        thread2.start();
    }


    public synchronized void thread1() {
        System.out.println("Thread1 started!");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
            this.notify();
            try {
                this.wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void thread2() {
        System.out.println("Thread2 started!");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
            this.notify();
            try {
                this.wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
