package com.java.practice.thread_;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/11/06 23:23
 */
class Thread1 implements Runnable {
    @Override
    public void run() {
        synchronized (TestThread.class) {
            System.out.println("enter thread1...");
            System.out.println("thread1 is waiting...");
            try {
                //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                TestThread.class.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is going on ....");
            System.out.println("thread1 is over!!!");
        }
    }
}
